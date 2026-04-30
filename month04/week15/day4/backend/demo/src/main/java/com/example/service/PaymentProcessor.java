package com.example.service;

public interface PaymentProcessor {
    boolean process(String orderId, double amount);
    String getName();
}
