package mn.icode.service;

public interface PaymentProcessor {
    boolean process(String orderId, double amount);
    String getName();
}
