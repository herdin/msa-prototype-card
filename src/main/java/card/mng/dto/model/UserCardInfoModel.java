package card.mng.dto.model;

import org.apache.ibatis.type.Alias;


@Alias("userCardInfoModel") //쿼리 xml에 resultType 과 동일하게
public class UserCardInfoModel {

    String user_id;
        String card_no;
        String card_sta_nm;
        String card_prd_id;
        String card_prd_nm;
        String card_prd_crg_nm;

    public UserCardInfoModel(String user_id, String card_no, String card_sta_nm, String card_prd_id, String card_prd_nm, String card_prd_crg_nm) {
        this.user_id = user_id;
        this.card_no = card_no;
        this.card_sta_nm = card_sta_nm;
        this.card_prd_id = card_prd_id;
        this.card_prd_nm = card_prd_nm;
        this.card_prd_crg_nm = card_prd_crg_nm;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_sta_nm() {
        return card_sta_nm;
    }

    public void setCard_sta_nm(String card_sta_nm) {
        this.card_sta_nm = card_sta_nm;
    }

    public String getCard_prd_id() {
        return card_prd_id;
    }

    public void setCard_prd_id(String card_prd_id) {
        this.card_prd_id = card_prd_id;
    }

    public String getCard_prd_nm() {
        return card_prd_nm;
    }

    public void setCard_prd_nm(String card_prd_nm) {
        this.card_prd_nm = card_prd_nm;
    }

    public String getCard_prd_crg_nm() {
        return card_prd_crg_nm;
    }

    public void setCard_prd_crg_nm(String card_prd_crg_nm) {
        this.card_prd_crg_nm = card_prd_crg_nm;
    }

    @Override
    public String toString() {
        return "UserCardInfoModel{" +
                "user_id='" + user_id + '\'' +
                ", card_no='" + card_no + '\'' +
                ", card_sta_nm='" + card_sta_nm + '\'' +
                ", card_prd_id='" + card_prd_id + '\'' +
                ", card_prd_nm='" + card_prd_nm + '\'' +
                ", card_prd_crg_nm='" + card_prd_crg_nm + '\'' +
                '}';
    }
}
