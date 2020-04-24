package card;

import card.mng.runner.VaultApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MainApplication.class);
        //application.addInitializers(new VaultApplicationContextInitializer());
        application.run(args);
    }
}
