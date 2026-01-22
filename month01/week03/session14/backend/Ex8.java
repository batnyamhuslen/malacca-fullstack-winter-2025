import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Тоо оруулна уу: ");
        int num = scanner.nextInt();

        boolean isPrime = true;

        
        if (num<=1) {
            isPrime=false;
        } else {
            
            for (int i = 2; i<num; i++) {
                if (num %i == 0) {  
                    isPrime =false;
                    break;  
                }
            }
        }

        if (isPrime) {
            System.out.println(num + " бол анхны тоо");
        } else {
            System.out.println(num + " бол анхны тоо биш");
        }

        scanner.close();
    }
}
