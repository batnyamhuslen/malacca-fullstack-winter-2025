package mn.icode.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mn.icode.service.NotificationService;
import mn.icode.service.PaymentProcessor;

@Component
public class ShopApp {

    private final NotificationService primaryNotification;   // SMS (@Primary)
    private final NotificationService emailNotification;     // Email (@Qualifier)
    private final PaymentProcessor defaultPayment;           // PayPal (@Primary)
    private final PaymentProcessor stripePayment;            // Stripe (@Qualifier)
    private final List<NotificationService> allNotifications;
    private final Map<String, PaymentProcessor> paymentMap;

    public ShopApp(
            NotificationService primaryNotification,
            @Qualifier("emailNotification") NotificationService emailNotification,
            PaymentProcessor defaultPayment,
            @Qualifier("stripe") PaymentProcessor stripePayment,
            List<NotificationService> allNotifications,
            Map<String, PaymentProcessor> paymentMap) {

        this.primaryNotification = primaryNotification;
        this.emailNotification = emailNotification;
        this.defaultPayment = defaultPayment;
        this.stripePayment = stripePayment;
        this.allNotifications = allNotifications;
        this.paymentMap = paymentMap;
    }

    public void processOrder(String orderId, String customer, double amount) {
        System.out.println("=== Order: " + orderId + " ===");

        // Default payment (PayPal)
        defaultPayment.process(orderId, amount);

        // Primary notification (SMS)
        primaryNotification.send(customer, "Order " + orderId + " confirmed!");

        // Email notification
        emailNotification.send(customer, "Order " + orderId + " confirmed!");

        // List all services
        System.out.println("Available notifications:");
        for (NotificationService ns : allNotifications) {
            System.out.println("  - " + ns.getType());
        }

        // Stripe-ийг тодорхой дуудах
        System.out.println("Also via Stripe:");
        paymentMap.get("stripe").process(orderId, amount);
    }
}