package card.mng.controller;

import card.mng.dto.model.CardModel;
import card.mng.dto.model.RequestModel;
import card.mng.dto.model.UserCardInfoModel;
import card.mng.mapper.CardMapper;
import card.mng.service.RemoteAPIService;
import org.apache.coyote.Response;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MngController {
    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private RemoteAPIService remoteAPIService;

    Logger logger = LoggerFactory.getLogger(MngController.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Integer> exceptionHandler(Exception e) {
        return ResponseEntity.badRequest().body(-1);
    }
    //카드전체조회
    @CrossOrigin
    @GetMapping("/AllCard")
    public List<CardModel>  getAllCard() {
        List<CardModel> value = cardMapper.getAllCard();
        logger.debug("Mapper return getAllCard-> {}", value);
        return value;
    }

    //카드상태조회
    @CrossOrigin
    @GetMapping("/CardInfo")
    public String getCardInfo(String cardNo) {
        String value = cardMapper.getCardInfo(cardNo);
        logger.debug("Mapper return getCardInfo-> {}", value);
        return value;
    }



    //회원의 카드 정보 조회
    @CrossOrigin
    @GetMapping(value = "/card/user/{userId}")
    public ResponseEntity<List<UserCardInfoModel>> getUserCardInfo(@PathVariable String userId) {

        String remoteUserId = remoteAPIService.getUser(userId);

        if(remoteUserId == null || "no-member".equals(remoteUserId)) {
            return ResponseEntity.status(491).body(null);
        }

        List<UserCardInfoModel> userCardInfoList = cardMapper.getUserCardInfo(userId);
        logger.debug("Mapper return getUserCardInfo-> {}", userCardInfoList);

        return ResponseEntity.ok().body(userCardInfoList);
    }

    //회원별 카드 등록 작업
    @CrossOrigin
    @PutMapping(value = "/card")
    public ResponseEntity<Integer> addUserCardInfo(@RequestBody CardModel cardModel) {

        int cnt =0;

        //카드상태 확인
        String value = cardMapper.getCardInfo(cardModel.getCardNo());

        //회원에서 입력한 카드번호가 원장에 있고 발급상태가 활성(00)인지 체크
        if("".equals(value) || !"00".equals(value)){
            logger.debug("Check your card number and status -> cardNo {}, staus: {}", cardModel,value);
            return ResponseEntity.status(490).body(cnt);
        }

        String remoteUserId = remoteAPIService.getUser(cardModel.getUserId());
        if(remoteUserId == null || "no-member".equals(remoteUserId)) {
            return ResponseEntity.status(491).body(cnt);
        }
        //저장
        cnt =cardMapper.addUserCardInfo(cardModel);
        logger.debug("Insert your card info -> id:{}, cardNo :{} , cnt:{}", cardModel, cnt);
        return ResponseEntity.ok().body(cnt);
    }

    //카드 상태 변경 작업
    @CrossOrigin
    @PostMapping(value = "/card")
    public ResponseEntity<Integer> updateUserCardInfo(String cardNo, String userId, String cardStatCd) {

        int cnt =0;

        //카드원장 확인
        String value = cardMapper.getCardInfo(cardNo);

        //회원에서 입력한 카드번호가 원장에 있는지 확인
        if("".equals(value)){
            logger.debug("Check your card number and status -> cardNo {}", cardNo);
            return ResponseEntity.badRequest().body(cnt);
        }else{
            //저장
            cnt =cardMapper.updateUserCardInfo(cardNo, userId,cardStatCd );
            logger.debug("Update your card info -> id:{}, cardNo :{} ,cardStatCd:{}, cnt:{}", userId, cardNo, cardStatCd,cnt);
            return ResponseEntity.ok().body(cnt);
        }
    }

    //회원별 카드삭제 작업
    @CrossOrigin
    @DeleteMapping(value = "/card")
    public int DeleteUserCard(String cardNo, String userId) {

        int cnt =0;

        //삭제
        cnt =cardMapper.deleteUserCardInfo(cardNo, userId );
        logger.debug("delete your card info -> id:{}, cardNo :{} , cnt:{}", userId, cardNo, cnt);

        //카드원장에 해당카드 비활성화
        cardMapper.updateCardInactive(cardNo);
        logger.debug("inactive your card info -> id:{}, cardNo :{} ", userId, cardNo);

        //삭제한 갯수 출력
        return cnt;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/user/{id}")
    @CrossOrigin
    public RequestModel getUser(@PathVariable String id) {
        RequestModel requestModel = new RequestModel(Integer.parseInt(id), "js");
        return requestModel;
    }

    @GetMapping("/user/detail")
    @CrossOrigin
    public String getUser(@ModelAttribute RequestModel requestModel) {
        return "user id is " + requestModel.getId() + " and name is " + requestModel.getName();
    }
}
