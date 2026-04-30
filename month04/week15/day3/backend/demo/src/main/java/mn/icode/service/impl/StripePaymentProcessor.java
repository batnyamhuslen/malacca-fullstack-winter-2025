package mn.icode.service.impl;

import org.springframework.stereotype.Component;

import mn.icode.service.PaymentProcessor;

@Component("stripe")

public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public boolean process(String orderId, double amount) {
        System.out.println("Stripe: $" + amount + " for " + orderId);
        return true;
    }

    @Override
    public String getName() { return "Stripe"; }
}