package card.mng.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("cardModel") //쿼리 xml에 resultType 과 동일하게
public class CardModel {

    String card_no,card_sta_cd,card_prd_id,rgsr_id,rgt_dtm,updr_id,upd_dtm;

    public CardModel(String card_no, String card_sta_cd, String card_prd_id, String rgsr_id, String rgt_dtm, String updr_id, String upd_dtm) {
        this.card_no = card_no;
        this.card_sta_cd = card_sta_cd;
        this.card_prd_id = card_prd_id;
        this.rgsr_id = rgsr_id;
        this.rgt_dtm = rgt_dtm;
        this.updr_id = updr_id;
        this.upd_dtm = upd_dtm;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_sta_cd() {
        return card_sta_cd;
    }

    public void setCard_sta_cd(String card_sta_cd) {
        this.card_sta_cd = card_sta_cd;
    }

    public String getCard_prd_id() {
        return card_prd_id;
    }

    public void setCard_prd_id(String card_prd_id) {
        this.card_prd_id = card_prd_id;
    }

    public String getRgsr_id() {
        return rgsr_id;
    }

    public void setRgsr_id(String rgsr_id) {
        this.rgsr_id = rgsr_id;
    }

    public String getRgt_dtm() {
        return rgt_dtm;
    }

    public void setRgt_dtm(String rgt_dtm) {
        this.rgt_dtm = rgt_dtm;
    }

    public String getUpdr_id() {
        return updr_id;
    }

    public void setUpdr_id(String updr_id) {
        this.updr_id = updr_id;
    }

    public String getUpd_dtm() {
        return upd_dtm;
    }

    public void setUpd_dtm(String upd_dtm) {
        this.upd_dtm = upd_dtm;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "card_no='" + card_no + '\'' +
                ", card_sta_cd='" + card_sta_cd + '\'' +
                ", card_prd_id='" + card_prd_id + '\'' +
                ", rgsr_id='" + rgsr_id + '\'' +
                ", rgt_dtm='" + rgt_dtm + '\'' +
                ", updr_id='" + updr_id + '\'' +
                ", upd_dtm='" + upd_dtm + '\'' +
                '}';
    }
}
