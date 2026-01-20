import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Худалдан авалтын дүн: ");
        double amount = sc.nextDouble();

        double discountRate = 0.0;

      
        if (amount >= 100000) {
            discountRate = 0.15;
        } else if (amount >= 50000) {
            discountRate = 0.10;
        } else if (amount >= 20000) {
            discountRate = 0.05;
        }

        double discountAmount = amount * discountRate;
        double finalAmount = amount - discountAmount;

       
        System.out.println();
        System.out.println("=== Төлбөрийн мэдээлэл ===");
        System.out.println("Анхны дүн: " + amount + "₮");
        System.out.println("Хөнгөлөлт: " + (discountRate * 100) + "% = " + discountAmount + "₮");
        System.out.println("Төлөх дүн: " + finalAmount + "₮");

        sc.close();
    }
}

