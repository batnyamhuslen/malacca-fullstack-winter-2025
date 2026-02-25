public class Acc {
    protected String owner;
    protected double balance;

    public Acc(String owner) {
        this.owner = owner;
        this.balance = 0.0;
    }

    public Acc(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

     public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "T orlogo hiigdle");
    }

    public void deposit(double amount, String tailbar) {
        balance += amount;
        System.out.println(amount + "T orlogo " + tailbar);
    }
    
}


