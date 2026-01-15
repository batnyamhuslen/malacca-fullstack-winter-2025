import java.util.Scanner;

public class AvargeScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Математик:");
        int math = scanner.nextInt();

        System.out.println("Англи хэл:");
        int language = scanner.nextInt();

        System.out.println("Програмчлал:");
        int programming = scanner.nextInt();

        double avarge = (math + language + programming) / 3;
        System.out.println("Дундаж оноо:" + avarge);

        scanner.close();


    }
}
