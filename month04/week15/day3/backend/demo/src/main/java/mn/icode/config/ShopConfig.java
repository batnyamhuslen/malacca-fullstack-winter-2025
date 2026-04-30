package mn.icode.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShopConfig {

    @Value("${shop.name}")
    private String shopName;

    @Value("${shop.currency}")
    private String currency;

    @Value("${shop.tax.rate:0.05}")   // default: 0.05
    private double taxRate;

    @Value("${notification.enabled:true}")
    private boolean notificationEnabled;

    public void printConfig() {
        System.out.println("=== Shop Config ===");
        System.out.println("Name:     " + shopName);
        System.out.println("Currency: " + currency);
        System.out.println("Tax:      " + taxRate);
        System.out.println("Notify:   " + notificationEnabled);
    }
}
