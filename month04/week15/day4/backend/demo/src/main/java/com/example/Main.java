package com.example;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.example.app.ShopApp;
import com.example.config.ShopConfig;
import com.example.service.impl.EmailNotificationService;
import com.example.service.impl.PayPalPaymentProcessor;
import com.example.service.impl.SmsNotificationService;
import com.example.service.impl.StripePaymentProcessor;

public class Main {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
        props.load(fis);
        fis.close();

        String  shopName  = props.getProperty("shop.name");
        String  currency  = props.getProperty("shop.currency");
        double  taxRate   = Double.parseDouble(props.getProperty("shop.tax.rate", "0.05"));
        boolean notify    = Boolean.parseBoolean(props.getProperty("notification.enabled", "true"));


        ShopConfig config = new ShopConfig(shopName, currency, taxRate, notify);


        EmailNotificationService emailService  = new EmailNotificationService();
        SmsNotificationService   smsService    = new SmsNotificationService();
        StripePaymentProcessor   stripeProc    = new StripePaymentProcessor();
        PayPalPaymentProcessor   paypalProc    = new PayPalPaymentProcessor();


        ShopApp shopApp = new ShopApp(
            smsService,                                  
            emailService,                                
            paypalProc,                                
            stripeProc,                                  
            List.of(smsService, emailService),           
            Map.of("stripe", stripeProc, "paypal", paypalProc)  
        );

        config.printConfig();
        System.out.println();
        shopApp.processOrder("ORD-001", "customer@example.com", 99.99);
    }
}