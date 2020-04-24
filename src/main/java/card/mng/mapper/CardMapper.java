package card.mng.mapper;

import card.mng.dto.model.CardModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CardMapper {

    //카드 전체 리스트 조회
    List<CardModel> getAllCard();

    //카드 정보 조회
    List<CardModel> getCard();

    //카드입력
    int addCard(CardModel cardModel);

}
