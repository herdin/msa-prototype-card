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
        mockMvc.perform(get("/getAllCard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"card_no\":\"1010000100010001\",\"card_sta_cd\":\"00\",\"card_prd_id\":\"00\",\"rgsr_id\":\"00\",\"rgt_dtm\":\"0\",\"updr_id\":null,\"upd_dtm\":null}]"))
        ;
    }

    @Test
    public void getCardInfo() throws Exception {
        logger.debug("card info load test");
        mockMvc.perform(get("/getCardInfo")
                .param("cardNo", "1010000100010001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("활성"))
        ;
    }
}