import java.util.Scanner;

public class BankTransferKhaan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Дансууд үүсгэх
        System.out.print("1-р дансны эзэмшигч: ");
        String owner1 = sc.nextLine();

        System.out.print("Эхний үлдэгдэл: ");
        double balance1 = sc.nextDouble();
        sc.nextLine();

        KhaanbankAccount acc1 = new KhaanbankAccount("001", owner1, balance1);

        System.out.print("\n2-р дансны эзэмшигч: ");
        String owner2 = sc.nextLine();

        System.out.print("Эхний үлдэгдэл: ");
        double balance2 = sc.nextDouble();
        sc.nextLine();

        KhaanbankAccount acc2 = new KhaanbankAccount("002", owner2, balance2);

        // // Шилжүүлэх дүн
        // System.out.print("\nШилжүүлэх дүн: ");
        // double amount = sc.nextDouble();

        
        // System.out.println("│ === Шилжүүлэг ===                   │");
        // System.out.printf("│ %s -> %s: %.0f₮               │\n", acc1.getOwnerName(), acc2.getOwnerName(), amount);

        // if (acc1.transfer(acc2, amount)) {
        //     System.out.println("│ Шилжүүлэг амжилттай!               │");
        // } else {
        //     System.out.println("│ Шилжүүлэг амжилтгүй! Үлдэгдэл хүрэлцэхгүй │");
        // }

       
        System.out.println("│ === Эцсийн байдал ===               │");
        System.out.printf("│ %s: %.0f₮                        │\n", acc1.getOwnerName(), acc1.getBalance());
        System.out.printf("│ %s: %.0f₮                       │\n", acc2.getOwnerName(), acc2.getBalance());

        sc.close();
    }
}
