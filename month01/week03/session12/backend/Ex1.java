import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.println("buhel too oruulna uu");
       
        if (num1% 2 == 0) {
            System.out.println("tegsh too" + num1);
        }else{
            System.out.println("sondgoi"+ num1);
        }
        scanner.close();
    }
}
