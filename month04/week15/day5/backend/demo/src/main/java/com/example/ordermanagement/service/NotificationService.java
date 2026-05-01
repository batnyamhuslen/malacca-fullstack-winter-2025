package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;

public interface NotificationService {
    void sendOrderConfirmation(Order order);
    void sendShippingNotification(Order order);
}
