import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Эхний тоо:");
        double num1 = scanner.nextDouble();

        System.out.println("Хоёрдахь тоо:");
        double num2 = scanner.nextDouble();

        double sum= num1 + num2;
        double diff= num1-num2;
        double product = num1* num2;
        double quotient = num1/num2;

        System.out.println("=== Үр дүн ===");
        System.out.println(num1 + "+"+ num2 + "="+sum);
        System.out.println(num1 + "-"+ num2 + "="+ diff);
        System.out.println(num1 + "*"+ num2 + "="+ product);
        System.out.println(num1 + "/"+ num2 + "="+ quotient);

        scanner.close();

    }
}
