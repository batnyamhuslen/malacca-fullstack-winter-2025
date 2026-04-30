package mn.icode;

import mn.icode.app.ShopApp;
import mn.icode.config.ShopConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiApplication implements CommandLineRunner {

    private final ShopApp shopApp;
    private final ShopConfig shopConfig;

    public SpringDiApplication(ShopApp shopApp, ShopConfig shopConfig) {
        this.shopApp = shopApp;
        this.shopConfig = shopConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        shopConfig.printConfig();
        System.out.println();
        shopApp.processOrder("ORD-001", "customer@example.com", 99.99);
    }
}