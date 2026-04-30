package com.example.service;

public interface NotificationService {
    void send(String to, String message);
    String getType();
}
