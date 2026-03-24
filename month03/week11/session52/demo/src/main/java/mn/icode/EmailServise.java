package mn.icode;

public class EmailServise implements Messanger {
    @Override
    public void sendMessage(String massage) {
        System.out.println("sending email message:" + massage);
    }
}
