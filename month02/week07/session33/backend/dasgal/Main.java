public class Main {
    public static void main(String[] args) {
        System.out.println("----bank system----");

        Accsaving s1 = new Accsaving( "hadgalamjiin dans bata", 1000000, 0.05);
        Accchecking c1 = new Accchecking("engiin dans dorj", 500000, 100000);

        System.out.println("bata -: " + s1.getBalance() + "₮");
        System.out.println("dorj -: " + c1.getBalance() + "₮");

        System.out.println("Orlogo bata");
        s1.deposit(500000);
        System.out.println("orlogo dorj" );
        c1.deposit(200000);

        System.out.println("Hvv");
        s1.applyInterest();

        System.out.println("Zarlaga dorj");
        c1.withdraw(300000);
        c1.withdraw(100000);
        c1.withdraw(50000);

        System.out.println("bata - " + s1.getBalance() );
        System.out.println("dorj - " + c1.getBalance());
    }
}
