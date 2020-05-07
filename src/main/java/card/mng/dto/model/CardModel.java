package card.mng.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("cardModel") //쿼리 xml에 resultType 과 동일하게
public class CardModel {

    String cardNo,cardStaCd,cardPrdId,rgsrId,rgtDtm,updrId,updDtm,userId;

    public CardModel(String cardNo, String cardStaCd, String cardPrdId, String rgsrId, String rgtDtm, String updrId, String updDtm, String userId) {
        this.cardNo = cardNo;
        this.cardStaCd = cardStaCd;
        this.cardPrdId = cardPrdId;
        this.rgsrId = rgsrId;
        this.rgtDtm = rgtDtm;
        this.updrId = updrId;
        this.updDtm = updDtm;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "cardNo='" + cardNo + '\'' +
                ", cardStaCd='" + cardStaCd + '\'' +
                ", cardPrdId='" + cardPrdId + '\'' +
                ", rgsrId='" + rgsrId + '\'' +
                ", rgtDtm='" + rgtDtm + '\'' +
                ", updrId='" + updrId + '\'' +
                ", updDtm='" + updDtm + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getcardStaCd() {
        return cardStaCd;
    }

    public void setcardStaCd(String cardStaCd) {
        this.cardStaCd = cardStaCd;
    }

    public String getCardPrdId() {
        return cardPrdId;
    }

    public void setCardPrdId(String cardPrdId) {
        this.cardPrdId = cardPrdId;
    }

    public String getRgsrId() {
        return rgsrId;
    }

    public void setRgsrId(String rgsrId) {
        this.rgsrId = rgsrId;
    }

    public String getRgtDtm() {
        return rgtDtm;
    }

    public void setRgtDtm(String rgtDtm) {
        this.rgtDtm = rgtDtm;
    }

    public String getUpdrId() {
        return updrId;
    }

    public void setUpdrId(String updrId) {
        this.updrId = updrId;
    }

    public String getUpdDtm() {
        return updDtm;
    }

    public void setUpdDtm(String updDtm) {
        this.updDtm = updDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
