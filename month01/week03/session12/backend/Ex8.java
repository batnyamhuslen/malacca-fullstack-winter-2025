import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "admin";
        String pass = "1234";

        System.out.print("Нэвтрэх нэр: ");
        String username = scanner.nextLine();

        System.out.print("Нууц үг: ");
        String password = scanner.nextLine();

        if (username.equals(name) && password.equals(pass)) {
            System.out.println("Амжилттай нэвтэрлээ!");
            System.out.println("Тавтай морил, " + username + "!");
            
        } else if (!username.equals(name)) {
            System.out.println("Алдаа: Нэвтрэх нэр буруу!");
        } else if (!password.equals(pass)) {
            System.out.println("Алдаа: Нууц үг буруу!");
        }
        scanner.close();
    }
}
