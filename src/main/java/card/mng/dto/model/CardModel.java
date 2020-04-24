package card.mng.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("cardModel") //쿼리 xml에 resultType 과 동일하게
public class CardModel {

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

    public String getCard_dvs_cd() {
        return card_dvs_cd;
    }

    public void setCard_dvs_cd(String card_dvs_cd) {
        this.card_dvs_cd = card_dvs_cd;
    }

    public String getCard_typ_cd() {
        return card_typ_cd;
    }

    public void setCard_typ_cd(String card_typ_cd) {
        this.card_typ_cd = card_typ_cd;
    }

    public int getCard_bal() {
        return card_bal;
    }

    public void setCard_bal(int card_bal) {
        this.card_bal = card_bal;
    }

    public String getBeng_use_dtm() {
        return beng_use_dtm;
    }

    public void setBeng_use_dtm(String beng_use_dtm) {
        this.beng_use_dtm = beng_use_dtm;
    }

    public String getBeng_chg_dtm() {
        return beng_chg_dtm;
    }

    public void setBeng_chg_dtm(String beng_chg_dtm) {
        this.beng_chg_dtm = beng_chg_dtm;
    }

    public String getBeng_pym_dtm() {
        return beng_pym_dtm;
    }

    public void setBeng_pym_dtm(String beng_pym_dtm) {
        this.beng_pym_dtm = beng_pym_dtm;
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
                ", card_dvs_cd='" + card_dvs_cd + '\'' +
                ", card_typ_cd='" + card_typ_cd + '\'' +
                ", card_bal=" + card_bal +
                ", beng_use_dtm='" + beng_use_dtm + '\'' +
                ", beng_chg_dtm='" + beng_chg_dtm + '\'' +
                ", beng_pym_dtm='" + beng_pym_dtm + '\'' +
                ", rgsr_id='" + rgsr_id + '\'' +
                ", rgt_dtm='" + rgt_dtm + '\'' +
                ", updr_id='" + updr_id + '\'' +
                ", upd_dtm='" + upd_dtm + '\'' +
                '}';
    }

    String card_no,card_sta_cd,card_dvs_cd,card_typ_cd;
    int card_bal;
    String beng_use_dtm,beng_chg_dtm,beng_pym_dtm,rgsr_id,rgt_dtm,updr_id,upd_dtm ;


    public CardModel(String card_no, String card_sta_cd, String card_dvs_cd, String card_typ_cd, int card_bal, String beng_use_dtm, String beng_chg_dtm, String beng_pym_dtm, String rgsr_id, String rgt_dtm, String updr_id, String upd_dtm) {
        this.card_no = card_no;
        this.card_sta_cd = card_sta_cd;
        this.card_dvs_cd = card_dvs_cd;
        this.card_typ_cd = card_typ_cd;
        this.card_bal = card_bal;
        this.beng_use_dtm = beng_use_dtm;
        this.beng_chg_dtm = beng_chg_dtm;
        this.beng_pym_dtm = beng_pym_dtm;
        this.rgsr_id = rgsr_id;
        this.rgt_dtm = rgt_dtm;
        this.updr_id = updr_id;
        this.upd_dtm = upd_dtm;
    }


}
