package card.mng.mapper;

import card.mng.dto.model.CardModel;
import card.mng.dto.model.UserCardInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CardMapper {

    //카드 전체 리스트 조회
    List<CardModel> getAllCard();

    //카드 상태 정보 조회
    String getCardInfo(String cardNo);

    //회원의 카드 정보 조회
    List<UserCardInfoModel> getUserCardInfo(String userId);

    //회원별 카드 등록 작업
    int addUserCardInfo(CardModel cardModel);

    //회원별 카드 상태 변경 작업
    int updateUserCardInfo(String cardNo, String userId, String cardStatCd);

    //회원별 카드 삭제 작업
    int deleteUserCardInfo(String cardNo, String userId);
    //카드삭제하면서 해당카드 원장에 비활성화 처리
    void updateCardInactive(String cardNo);

}
