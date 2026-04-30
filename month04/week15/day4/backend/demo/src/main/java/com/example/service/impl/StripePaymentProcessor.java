package com.example.service.impl;

import com.example.service.PaymentProcessor;

public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public boolean process(String orderId, double amount) {
        System.out.println("Stripe: $" + amount + " for " + orderId);
        return true;
    }

    @Override
    public String getName() { return "Stripe"; }
}
