import java.util.Scanner;

public class Ex3 {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choise;
    do{
        System.out.println("n=== MENU ===");
        System.out.println("1. Эхлэх");
        System.out.println("2. Тохиргоо");
        System.out.println("3. Гарах");
        System.out.println("Сонголт:");
        choise= scanner.nextInt();

        if (choise==1) {
            System.out.println("Эхэллээ...");
        }else if (choise ==2) {
            System.out.println("Тохиргоо нээгдлээ...");
        }else if (choise==3) {
            System.out.println("Баяртай!");
        }else {
            System.out.println("Буруу сонголт!");
        }
    } while( choise != 3 );
    scanner.close();
   } 
}
