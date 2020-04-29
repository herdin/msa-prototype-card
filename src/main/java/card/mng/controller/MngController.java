package card.mng.controller;

import card.mng.dto.model.CardModel;
import card.mng.dto.model.RequestModel;
import card.mng.mapper.CardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MngController {
    @Autowired
    private CardMapper cardMapper;

    Logger logger = LoggerFactory.getLogger(MngController.class);

    //카드전체조회
    @GetMapping("/getAllCard")
    public List<CardModel>  getAllCard() {
        List<CardModel> value = cardMapper.getAllCard();
        logger.debug("Mapper return getAllCard-> {}", value);
        return value;
    }

    //카드상태조회
    @GetMapping("/getCardInfo")
    public String getCardInfo(String cardNo) {
        String value = cardMapper.getCardInfo(cardNo);
        logger.debug("Mapper return getCardInfo-> {}", value);
        return value;
    }

    @PostMapping("/user")
    public String addCardService() {
        //저장
        return "save";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/user")
    public String addUser2() {
        //저장
        return "save";
    }

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
