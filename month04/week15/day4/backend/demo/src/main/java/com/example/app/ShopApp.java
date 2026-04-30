package com.example.app;

import java.util.List;
import java.util.Map;

import com.example.service.NotificationService;
import com.example.service.PaymentProcessor;

public class ShopApp {

    private final NotificationService primaryNotification;
    private final NotificationService emailNotification;
    private final PaymentProcessor    defaultPayment;
    private final PaymentProcessor    stripePayment;
    private final List<NotificationService>       allNotifications;
    private final Map<String, PaymentProcessor>   paymentMap;

    public ShopApp(
            NotificationService primaryNotification,
            NotificationService emailNotification,
            PaymentProcessor    defaultPayment,
            PaymentProcessor    stripePayment,
            List<NotificationService>     allNotifications,
            Map<String, PaymentProcessor> paymentMap) {
        this.primaryNotification = primaryNotification;
        this.emailNotification   = emailNotification;
        this.defaultPayment      = defaultPayment;
        this.stripePayment       = stripePayment;
        this.allNotifications    = allNotifications;
        this.paymentMap          = paymentMap;
    }

    public void processOrder(String orderId, String customer, double amount) {
        System.out.println("=== Order: " + orderId + " ===");

        defaultPayment.process(orderId, amount);
        primaryNotification.send(customer, "Order " + orderId + " confirmed!");
        emailNotification.send(customer, "Order " + orderId + " confirmed!");

        System.out.println("Available notifications:");
        for (NotificationService ns : allNotifications) {
            System.out.println("  - " + ns.getType());
        }

        System.out.println("Also via Stripe:");
        paymentMap.get("stripe").process(orderId, amount);
    }
}