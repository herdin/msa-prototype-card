package card.mng.dto.model;

import org.apache.ibatis.type.Alias;


@Alias("userCardInfoModel") //쿼리 xml에 resultType 과 동일하게
public class UserCardInfoModel {
    String userId;
    String cardNo;
    String cardStaNm;
    String cardPrdId;
    String cardPrdNm;
    String cardPrdCrgNm;

    @Override
    public String toString() {
        return "UserCardInfoModel{" +
                "userId='" + userId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardStaNm='" + cardStaNm + '\'' +
                ", cardPrdId='" + cardPrdId + '\'' +
                ", cardPrdNm='" + cardPrdNm + '\'' +
                ", cardPrdCrgNm='" + cardPrdCrgNm + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardStaNm() {
        return cardStaNm;
    }

    public void setCardStaNm(String cardStaNm) {
        this.cardStaNm = cardStaNm;
    }

    public String getCardPrdId() {
        return cardPrdId;
    }

    public void setCardPrdId(String cardPrdId) {
        this.cardPrdId = cardPrdId;
    }

    public String getCardPrdNm() {
        return cardPrdNm;
    }

    public void setCardPrdNm(String cardPrdNm) {
        this.cardPrdNm = cardPrdNm;
    }

    public String getCardPrdCrgNm() {
        return cardPrdCrgNm;
    }

    public void setCardPrdCrgNm(String cardPrdCrgNm) {
        this.cardPrdCrgNm = cardPrdCrgNm;
    }

    public UserCardInfoModel(String userId, String cardNo, String cardStaNm, String cardPrdId, String cardPrdNm, String cardPrdCrgNm) {
        this.userId = userId;
        this.cardNo = cardNo;
        this.cardStaNm = cardStaNm;
        this.cardPrdId = cardPrdId;
        this.cardPrdNm = cardPrdNm;
        this.cardPrdCrgNm = cardPrdCrgNm;
    }


}
