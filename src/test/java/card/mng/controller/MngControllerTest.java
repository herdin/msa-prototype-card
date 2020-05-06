package card.mng.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MngControllerTest {
    Logger logger = LoggerFactory.getLogger(MngControllerTest.class);
    @Autowired
    MockMvc mockMvc;

    //@Test
    public void getAllCard() throws Exception {
        logger.debug("card list load test");
        mockMvc.perform(get("/AllCard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"card_no\":\"1010000100010001\",\"card_sta_cd\":\"00\",\"card_prd_id\":\"00\",\"rgsr_id\":\"00\",\"rgt_dtm\":\"0\",\"updr_id\":null,\"upd_dtm\":null}]"))
        ;
    }

    //@Test
    public void getCardInfo() throws Exception {
        logger.debug("card info load test");
        mockMvc.perform(get("/CardInfo")
                .param("cardNo", "1010000100010001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("00"))
        ;
    }

    //@Test
    public void getUserCardInfo() throws Exception {
        logger.debug("user card info load test");
        mockMvc.perform(get("/UserCardInfo")
                .param("userId", "s.jo0701"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"user_id\":\"s.jo0701\",\"card_no\":\"1010000100010001\",\"card_sta_nm\":\"Active\",\"card_prd_id\":\"001\",\"card_prd_nm\":\"Tmoney\",\"card_prd_crg_nm\":\"Tmoney\"},{\"user_id\":\"s.jo0701\",\"card_no\":\"1010000100010002\",\"card_sta_nm\":\"Inactive\",\"card_prd_id\":\"002\",\"card_prd_nm\":\"Shinhan Tmoney\",\"card_prd_crg_nm\":\"Alliance Tmoney\"}]")
                )
        ;
    }

    //@Test
    public void addUserCardInfo() throws Exception {
        logger.debug("user card info insert test");
        mockMvc.perform(get("/UserCardInfoSave")
                .param("userId", "s.jo0701")
                .param("cardNo", "1010000100010006"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1")
                )
        ;
    }

    //@Test
    public void updateUserCardInfo() throws Exception {
        logger.debug("user card info update test");
        mockMvc.perform(get("/UserCardInfoUpdate")
                .param("userId", "s.jo0701")
                .param("cardNo", "1010000100010006")
                .param("cardStatCd", "01")        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1")
                )
        ;
    }

    @Test
    public void deleteUserCard() throws Exception {
        logger.debug("user card info delete test");
        mockMvc.perform(get("/UserCardDelete")
                .param("userId", "s.jo0701")
                .param("cardNo", "1010000100010006"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1")
                )
        ;
    }
}