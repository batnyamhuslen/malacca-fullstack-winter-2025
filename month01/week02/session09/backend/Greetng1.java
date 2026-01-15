import java.util.Scanner;

public class Greetng1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Нэрээ оруулна уу:");
        String name = scanner.nextLine();

        System.out.println("Сайн байна уу," + name + "!");
        scanner.close();
    }
}
