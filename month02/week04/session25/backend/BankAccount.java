public class BankAccount {
    private int accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(int accountNumber, String ownerName) {
        this.balance = 0.0;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public BankAccount(int accountNumber, String ownerName, double initialbalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialbalance;
    }

    public int GetNumber() {
        return accountNumber;
    }

    public String GetName() {
        return ownerName;
    }

    public double GetBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    

    public void DisplayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
    }

}
