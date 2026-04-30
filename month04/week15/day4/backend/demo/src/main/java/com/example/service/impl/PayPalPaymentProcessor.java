package com.example.service.impl;

import com.example.service.PaymentProcessor;

public class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean process(String orderId, double amount) {
        System.out.println("PayPal: $" + amount + " for " + orderId);
        return true;
    }

    @Override
    public String getName() { return "PayPal"; }
}
