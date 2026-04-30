package mn.icode.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import mn.icode.service.NotificationService;

@Component("smsNotification")
@Primary   
public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] To: " + to);
        System.out.println("[SMS] " + message);
    }

    @Override
    public String getType() { return "SMS"; }
}