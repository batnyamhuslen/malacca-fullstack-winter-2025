package mn.icode.service;

public interface NotificationService {
    void send(String to, String message);
    String getType();
}
