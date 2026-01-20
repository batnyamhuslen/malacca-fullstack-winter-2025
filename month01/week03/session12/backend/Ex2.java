import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println("too oruulan u ");
         int num1 = scanner.nextInt();
       
        
        if (num1 < 0) {
            System.out.println("Сөрөг"+num1);
        }else if (num1 >0) {
            System.out.println("Эерэг#"+num1);
        }else{
            System.out.println("teg"+num1);

        }
    }
}
