package mn.icode.service.impl;

import org.springframework.stereotype.Component;

import mn.icode.service.NotificationService;

@Component("emailNotification")            // bean name = "emailNotification"
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL] To: " + to);
        System.out.println("[EMAIL] " + message);
    }

    @Override
    public String getType() { return "Email"; }
}
