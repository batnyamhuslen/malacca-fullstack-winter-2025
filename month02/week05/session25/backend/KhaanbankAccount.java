public class KhaanbankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public KhaanbankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
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

    // public boolean transfer(BankAccount targetAccount, double amount) {
    //     if (withdraw(amount)) {
    //         targetAccount.deposit(amount);
    //         return true;
    //     }
    //     return false;
    // }

    public void displayInfo() {
        System.out.printf("%s: %.0f₮\n", ownerName, balance);
    }
}
