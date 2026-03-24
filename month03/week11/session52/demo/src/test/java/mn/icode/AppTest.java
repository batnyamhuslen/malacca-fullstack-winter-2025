package mn.icode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   public static void main(String[] args) {
    Messanger myService;
    myService = new EmailServise();
    myService.sendMessage("hello student");

    myService = new SMSservice();
    myService.sendMessage("call class in 5 minutes");
   }
}
