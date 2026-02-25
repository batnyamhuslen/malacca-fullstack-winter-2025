public class Accsaving extends Acc {
    private double interestRate;

    public Accsaving(String owner, double balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double getBalance() {
        return balance+(balance*interestRate);
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;

        System.out.println("hvvgiin nemegdel " + interest + "T");
        System.out.println("vldegdel " + balance + "T");
    }
}
