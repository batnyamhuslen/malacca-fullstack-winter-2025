public class Accchecking extends Acc {
    private double overdraftLimit;

    public Accchecking(String owner, double balance, double overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println(amount + "T zarlaga hiile");
        } else {
            System.out.println("uldegdel hureltsehgui baina");
        }
    }

    public void withdraw(double amount, double feePercent) {
        double fee = amount * feePercent;

        if (amount + fee <= balance + overdraftLimit) {
            balance -= (amount + fee);
            System.out.println(amount + "Zarlaga (shimtgel " + fee + "T)");
            System.out.println("uldegdel " + balance + "T");
        } else {
            System.out.println("uldegdel hureltsehgui baina");
        }
    }
}
