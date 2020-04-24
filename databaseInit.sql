
DROP TABLE TB_CARDPRD;
DROP TABLE TB_CARD;
DROP TABLE TB_MEMCARD ;

CREATE TABLE TB_CARDPRD (
                            CARD_PRD_ID VARCHAR(3)  PRIMARY KEY ,--카드상품ID
                            CARD_PRD_NM VARCHAR(40),           --카드상품명
                            CARD_PRD_CRG_CD VARCHAR(2),        --카드상품분류코드(01: 자사, 02: 카드제휴, 03:모바일제휴, 04:클라우드티머니)
                            RGSR_ID      VARCHAR(14),          --등록자ID
                            RGT_DTM      VARCHAR(14),          --등록일시
                            UPDR_ID      VARCHAR(14),          --수정자ID
                            UPD_DTM      VARCHAR(14)          --수정일시
)
;

INSERT INTO TB_CARDPRD
VALUES ( '001'
       , '티머니 오리지날'
       , '01'
       , NULL
       , NULL
       , 'ADMIN'
       , to_char(now(),'YYYYMMDDHH24MISS')
       )
;




CREATE TABLE TB_CARD(
                        CARD_NO VARCHAR(16) PRIMARY KEY , --카드번호
                        CARD_STA_CD VARCHAR(2) ,          --카드상태코드(00:활성, 01:비활성, 02:분실, 03:폐기, 04: 미발급)
                        CARD_PRD_ID VARCHAR(3)   REFERENCES TB_CARDPRD(CARD_PRD_ID ) ,--카드상품ID
                        RGSR_ID      VARCHAR(14),          --등록자ID
                        RGT_DTM      VARCHAR(14),          --등록일시
                        UPDR_ID      VARCHAR(14),          --수정자ID
                        UPD_DTM      VARCHAR(14)          --수정일시
)
;

INSERT INTO TB_CARD
VALUES ( '1010000100010001'
       , '00'
       , '001'
       , NULL
       , NULL
       , 'ADMIN'
       , to_char(now(),'YYYYMMDDHH24MISS')
       )
;


CREATE TABLE TB_MEMCARD (
                            USER_ID VARCHAR(20)  , --회원ID
                            CARD_NO VARCHAR(16)   , --카드번호
                            RGSR_ID      VARCHAR(14),          --등록자ID
                            RGT_DTM      VARCHAR(14),          --등록일시
                            UPDR_ID      VARCHAR(14),          --수정자ID
                            UPD_DTM      VARCHAR(14)          --수정일시
    ,primary key(USER_ID, CARD_NO)
)
;


INSERT INTO TB_MEMCARD
VALUES ( 'joshin'
       ,'1010000100010001'

       , NULL
       , NULL
       , 'ADMIN'
       ,to_char(now(),'YYYYMMDDHH24MISS')
       )
;



