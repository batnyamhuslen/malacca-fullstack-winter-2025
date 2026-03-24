package mn.icode;

public class SMSservice implements Messanger {
    @Override
    public void sendMessage(String message) {
       System.out.println("sending sms message:"+ message);
    }
}
