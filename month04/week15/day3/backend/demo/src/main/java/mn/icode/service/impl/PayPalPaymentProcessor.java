package mn.icode.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import mn.icode.service.PaymentProcessor;

@Component("paypal")
@Primary   
public class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean process(String orderId, double amount) {
        System.out.println("PayPal: $" + amount + " for " + orderId);
        return true;
    }

    @Override
    public String getName() { return "PayPal"; }
}