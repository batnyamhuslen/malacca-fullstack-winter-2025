package mn.icode;

public class Payments {
    public static void main( String[] args ){
        Qpay qpay = new Qpay();
        qpay.proccesPayment(10000);
    }
}
interface PaymentMethod {
    void proccesPayment(double amount);
}

class Qpay implements PaymentMethod{
    @Override 
    public void proccesPayment(double amount){
        System.out.println("proccesing" + amount + "$ qpay");
    }
}
class SocialPay implements PaymentMethod {
    @Override
    public void proccesPayment(double amount){
        System.out.println("swimming social pay"+amount + "$");
    }
}