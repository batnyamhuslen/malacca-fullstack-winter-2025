package mn.icode;

/**
 * Hello world!
 *
 */
public class App 
{
  public static void main(String[] args) {
    Messanger myService;
    myService = new EmailServise();
    myService.sendMessage("hello student");

    myService = new SMSservice();
    myService.sendMessage("call start in 5 minutes");

    Behaviour myBehaviour;
    myBehaviour = new Friendlybehaviour();
    myBehaviour.act("happy");

    myBehaviour = new Angrybehaviour();
    myBehaviour.act("angry");
   }
}
