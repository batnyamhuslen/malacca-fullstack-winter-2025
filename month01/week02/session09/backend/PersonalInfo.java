import java.util.Scanner;

public class PersonalInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Нас:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\"Нэр:");
        String name = scanner.nextLine();

        System.out.println("Хот:");
        String city = scanner.nextLine();

        System.out.println("=== Мэдээлэл ===");
        System.out.println("Нэр:" + name);
        System.out.println("Нас" + age);
        System.out.println("\"Хот:" + city);

        scanner.close();
    }
}
