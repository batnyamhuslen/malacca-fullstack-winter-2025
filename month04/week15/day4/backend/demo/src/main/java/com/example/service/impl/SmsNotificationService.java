package com.example.service.impl;

import com.example.service.NotificationService;

public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] To: " + to);
        System.out.println("[SMS] " + message);
    }

    @Override
    public String getType() { return "SMS"; }
}
