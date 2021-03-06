package card.mng.runner;

import card.mng.mapper.CardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import org.springframework.core.env.Environment;

import java.util.Arrays;

@Component
public class PostgreSQLRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(PostgreSQLRunner.class);

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("hello! {}", this.getClass().getSimpleName());
        Arrays.stream(environment.getActiveProfiles()).forEach(profile -> logger.debug("active profile -> {}", profile));

        logger.debug("database url in property -> {}", environment.getProperty("spring.datasource.url"));
        logger.debug("database username in property -> {}", environment.getProperty("spring.datasource.username"));
        logger.debug("database password in property -> {}", environment.getProperty("spring.datasource.password"));
        //logger.debug("get card status  -> {}", cardMapper.getCardInfo("1010000100010001"));
        //logger.debug("get card register info  -> {}", cardMapper.getUserCardInfo("s.jo0701"));
        //logger.debug("add user card register info  -> {}", cardMapper.addUserCardInfo("1010000100010006","s.jo0701"));
        //logger.debug("update user card info  -> {}", cardMapper.updateUserCardInfo("1010000100010006","s.jo0701","01"));
        //logger.debug("delete user card info  -> {}", cardMapper.deleteUserCardInfo("1010000100010006","s.jo0701"));
    }
}





