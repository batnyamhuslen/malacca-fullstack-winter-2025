package com.example.service.impl;

import com.example.service.NotificationService;

public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL] To: " + to);
        System.out.println("[EMAIL] " + message);
    }

    @Override
    public String getType() { return "Email"; }
}
