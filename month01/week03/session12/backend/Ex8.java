import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "1234";

        System.out.print("Нэвтрэх нэр: ");
        String username = scanner.nextLine();

        System.out.print("Нууц үг: ");
        String password = scanner.nextLine();

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Амжилттай нэвтэрлээ!");
            System.out.println("Тавтай морил, " + username + "!");
        } else if (!username.equals(correctUsername)) {
            System.out.println("Алдаа: Нэвтрэх нэр буруу!");
        } else if (!password.equals(correctPassword)) {
            System.out.println("Алдаа: Нууц үг буруу!");
        }
        scanner.close();
    }
}
