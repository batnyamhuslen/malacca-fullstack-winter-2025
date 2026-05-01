package com.example.ordermanagement.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.NotificationService;

@Service("smsNotification")
@Primary   // ← NotificationService inject хийхэд @Qualifier байхгүй бол энийг сонгоно
public class SmsNotificationService implements NotificationService{
    @Override
public void sendOrderConfirmation(Order order) {
    System.out.println("  [SMS] To:  " + order.getCustomer().getPhone());
    System.out.printf(
        "  [SMS] Msg: Order #%d confirmed! Total: $%.2f%n",
        order.getId(),
        order.getTotal()
    );
}

@Override
public void sendShippingNotification(Order order) {
    System.out.println("  [SMS] To:  " + order.getCustomer().getPhone());
    System.out.printf(
        "  [SMS] Msg: Order #%d is on its way!%n",
        order.getId()
    );
}
}
