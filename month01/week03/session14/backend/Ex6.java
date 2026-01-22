import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPassword = "secret123";
        int attemps = 1;
        int maxAttempts=4;

        while(attemps<maxAttempts) {
            System.out.println("Нууц үг оруулна уу:");
            String input = sc.nextLine();

            if(input.equals(correctPassword)){
                System.out.println("Амжилттай нэвтэрлээ!");
                break;
            }else{
                attemps++;
                System.out.println("Буруу! Үлдсэн оролдлого:"+(maxAttempts-attemps));
            }
        }
        if (attemps>=maxAttempts) {
            System.out.println("Хаяг блоклогдлоо!");
        }
        sc.close();
    }
}
