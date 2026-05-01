package com.example.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.NotificationService;

@Service("emailNotification")        // ← bean нэр тодорхойлно (@Qualifier-д ашиглана)
public class EmailNotificationService implements NotificationService {

    @Value("${notification.email.from:noreply@shop.com}")
    private String fromEmail;        // ← application.properties-ийн утга

    @Override
    public void sendOrderConfirmation(Order order) {
        System.out.println("  [EMAIL] From:    " + fromEmail);
        System.out.println("  [EMAIL] To:      " + order.getCustomer().getEmail());
        System.out.println("  [EMAIL] Subject: Order #" + order.getId() + " Confirmed");
        System.out.printf("  [EMAIL] Body:    Total: $%.2f%n", order.getTotal());
    }

    @Override
    public void sendShippingNotification(Order order) {
        System.out.println("  [EMAIL] To:      " + order.getCustomer().getEmail());
        System.out.println("  [EMAIL] Subject: Order #" + order.getId() + " Shipped!");
    }
}
