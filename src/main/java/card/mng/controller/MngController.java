package card.mng.controller;

import card.mng.dto.model.CardModel;
import card.mng.dto.model.RequestModel;
import card.mng.dto.model.UserCardInfoModel;
import card.mng.mapper.CardMapper;
import card.mng.service.RemoteAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    //카드전체조회
    @GetMapping("/AllCard")
    public List<CardModel>  getAllCard() {
        List<CardModel> value = cardMapper.getAllCard();
        logger.debug("Mapper return getAllCard-> {}", value);
        return value;
    }

    //카드상태조회
    @GetMapping("/CardInfo")
    public String getCardInfo(String cardNo) {
        String value = cardMapper.getCardInfo(cardNo);
        logger.debug("Mapper return getCardInfo-> {}", value);
        return value;
    }

    /*@GetMapping("/remoteHello")
    public String remoteHello(String url) throws URISyntaxException {
        logger.debug("remote hello -> {}", url);
        return remoteAPIService.getStringResult(url);
    }*/

    //회원의 카드 정보 조회
    @GetMapping("/UserCardInfo")
    public List<UserCardInfoModel> getUserCardInfo(String userId)  throws URISyntaxException {

        //카드등록 화면에서 가져온 값
        userId = "s.jo0701";

        List<UserCardInfoModel> value = cardMapper.getUserCardInfo(userId);
        logger.debug("Mapper return getUserCardInfo-> {}", value);
        return value;
    }

    //회원별 카드 등록 작업
    @GetMapping(value = "/UserCardInfoSave")
    public int addUserCardInfo(String cardNo, String userId) {

        int cnt =0;

        //카드등록 화면에서 가져온 값
        cardNo = "1010000100010006";
        userId = "s.jo0701";

        //카드상태 확인
        String value = cardMapper.getCardInfo(cardNo);

        //회원에서 입력한 카드번호가 원장에 있고 발급상태가 활성(00)인지 체크
        if(value.equals("") || !value.equals("00")){
            logger.debug("Check your card number and status -> cardNo {}, staus: {}", cardNo,value);
        }else{
            //저장
            cnt =cardMapper.addUserCardInfo(cardNo, userId);
            logger.debug("Insert your card info -> id:{}, cardNo :{} , cnt:{}", userId, cardNo, cnt);
        }

        //저장한 갯수 출력
        return cnt;
    }

    //카드 상태 변경 작업
    @GetMapping(value = "/UserCardInfoUpdate")
    public int updateUserCardInfo(String cardNo, String userId, String cardStatCd) {

        int cnt =0;

        //카드등록 화면에서 가져온 값
        cardNo = "1010000100010006";
        userId = "s.jo0701";
        cardStatCd = "01";  //카드상태코드(00:활성, 01:비활성, 02:분실, 03:폐기, 04: 미발급)

        //카드원장 확인
        String value = cardMapper.getCardInfo(cardNo);

        //회원에서 입력한 카드번호가 원장에 있는지 확인
        if(value.equals("")){
            logger.debug("Check your card number and status -> cardNo {}", cardNo);
        }else{
            //저장
            cnt =cardMapper.updateUserCardInfo(cardNo, userId,cardStatCd );
            logger.debug("Update your card info -> id:{}, cardNo :{} ,cardStatCd:{}, cnt:{}", userId, cardNo, cardStatCd,cnt);
        }

        //수정한 갯수 출력
        return cnt;
    }

    //회원별 카드삭제 작업
    @GetMapping(value = "/UserCardDelete")
    public int DeleteUserCard(String cardNo, String userId) {

        int cnt =0;

        //카드등록 화면에서 가져온 값
        cardNo = "1010000100010006";
        userId = "s.jo0701";

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
    public RequestModel getUser(@PathVariable String id) {
        RequestModel requestModel = new RequestModel(Integer.parseInt(id), "js");
        return requestModel;
    }

    @GetMapping("/user/detail")
    public String getUser(@ModelAttribute RequestModel requestModel) {
        return "user id is " + requestModel.getId() + " and name is " + requestModel.getName();
    }
}
