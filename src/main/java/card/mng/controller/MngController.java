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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@Transactional
//@TransactionConfiguration(defalutRollback=true)
public class MngController {
    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private RemoteAPIService remoteAPIService;

    Logger logger = LoggerFactory.getLogger(MngController.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Integer> exceptionHandler(Exception e) {
        logger.debug("Exception comment"+ResponseEntity.badRequest().body(e));
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
    @GetMapping(value = "/card/member/{userId}")
    public ResponseEntity<List<UserCardInfoModel>> getUserCardInfo(@PathVariable String userId) {

        String remoteUserId = remoteAPIService.getUser(userId);
        logger.debug("remote user id {}", remoteUserId);

        if(remoteUserId == null || "no-member".equals(remoteUserId)) {
            logger.debug("user id error {}", remoteUserId);
            return ResponseEntity.status(491).body(null);
        }

        List<UserCardInfoModel> userCardInfoList = cardMapper.getUserCardInfo(userId);
        logger.debug("Mapper return getUserCardInfo-> {}", userCardInfoList);

        return ResponseEntity.ok().body(userCardInfoList);
    }

    //회원별 카드 등록 작업
    @CrossOrigin
    @PutMapping(value = "/card/{cardNo}/member/{userId}")
    public ResponseEntity<Integer> addUserCardInfo(@PathVariable String userId,@PathVariable String cardNo) {

        String remoteUserIdCard = remoteAPIService.getUser(userId);

        if(remoteUserIdCard == null  || "no-member".equals(remoteUserIdCard)) {
            logger.debug("Check userId {}",remoteUserIdCard);
            return ResponseEntity.status(491).body(null);
        }
        //카드상태 확인
        String status = cardMapper.getCardInfo(cardNo);

        //회원에서 입력한 카드번호가 원장에 있고 발급상태가 활성(00)인지 체크
        if("".equals(status) || !"00".equals(status)) {
            logger.debug("Check your card number and status -> userId {}, cardNo {}, staus: {}", userId, cardNo, status);
            return ResponseEntity.status(492).body(null);
        }

        //다른 회원이 등록한 카드인지 확인
        int rgtStatus = cardMapper.getMemCardInfo(cardNo);

        if(rgtStatus>0){
            logger.debug("Someone already use your card number -> cardNo {}", cardNo);
            return ResponseEntity.status(493).body(null);
        }

        //저장
        cardMapper.addUserCardInfo(userId,cardNo);
        logger.debug("Insert your card info -> id:{}, cardNo :{} ", userId, cardNo);
        return ResponseEntity.ok().body(null);
    }

    //회원별 카드삭제 작업
    @CrossOrigin
    @DeleteMapping(value = "/card/{cardNo}/member/{userId}")
    public ResponseEntity<Integer> DeleteUserCard(@PathVariable String userId,@PathVariable String cardNo) {

        String remoteUserIdCard = remoteAPIService.getUser(userId);

        if(remoteUserIdCard == null  || "no-member".equals(remoteUserIdCard)) {
            logger.debug("Check userId {}",remoteUserIdCard);
            return ResponseEntity.status(491).body(null);
        }

        //삭제
        cardMapper.deleteUserCardInfo(cardNo, userId );
        logger.debug("delete your card info -> id:{}, cardNo :{} ", userId, cardNo);

        return ResponseEntity.ok().body(null);
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
