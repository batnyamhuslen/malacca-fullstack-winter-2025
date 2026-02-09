// public class BankAccountFull {
//     public static void main(String[] args) {
//         BankAccount acc1 = new BankAccount(517411742, "Khuslen");
//         BankAccount acc2 = new BankAccount(512323232, "Saraa", 100000);

//         System.out.println("=== Анхны байдал ===");
//         acc1.DisplayInfo();
//         acc2.DisplayInfo();

//         System.out.println("\n=== Гүйлгээ ===");
//         acc1.deposit(100000);
//         acc2.withdraw(30000);
//         acc1.withdraw(50000);

//         System.out.println("\\n=== Эцсийн байдал ===");
//         acc1.DisplayInfo();
//         acc2.DisplayInfo();

//     }
// }

import java.util.Scanner;

public class BankAccountFull {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("1-р дансны дугаар: ");
        int accNum1 = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("1-р эзэмшигчийн нэр: ");
        String name1 = keyboard.nextLine();

        BankAccount acc1 = new BankAccount(accNum1, name1);

        System.out.print("\n2-р дансны дугаар: ");
        int accNum2 = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("2-р эзэмшигчийн нэр: ");
        String name2 = keyboard.nextLine();

        BankAccount acc2 = new BankAccount(accNum2, name2);

        System.out.println("\n=== Анхны байдал ===");
        acc1.DisplayInfo();
        acc2.DisplayInfo();

        System.out.println("\n=== Гүйлгээ ===");

        System.out.print("acc1-д хийх орлого: ");
        double dep = keyboard.nextDouble();
        acc1.deposit(dep);

        System.out.print("acc2-д хийх орлого: ");
        double dep2 = keyboard.nextDouble();
        acc2.deposit(dep2);

        System.out.print("acc1-с авах мөнгө: ");
        double with1 = keyboard.nextDouble();
        acc1.withdraw(with1);

        System.out.print("acc2-с авах мөнгө: ");
        double with2 = keyboard.nextDouble();
        acc2.withdraw(with2);

        System.out.println("\n=== Эцсийн байдал ===");
        acc1.DisplayInfo();
        acc2.DisplayInfo();

        keyboard.close();
    }
}
