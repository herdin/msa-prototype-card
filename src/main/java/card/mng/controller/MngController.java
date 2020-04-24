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

    @GetMapping("/cardAllInqr")
    public List<CardModel>  cardAllInqr() {
        List<CardModel> value = cardMapper.getAllCard();
        logger.debug("return -> {}", value);
        return value;
    }

    @GetMapping("/cardInqr")
    public List<CardModel> cardInqr() {
        List<CardModel> value = cardMapper.getCard();
        logger.debug("return -> {}", value);
        return value;
    }

    @PostMapping("/user")
    public String addUser() {
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
