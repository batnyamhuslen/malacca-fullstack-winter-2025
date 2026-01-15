import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Оюутны Бүртгэл ===");

        System.out.println("\"Нэр:");
        String name = scanner.nextLine();

        System.out.println("\"Нас:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Курс (1-4):");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("GPA (0.0-4.0):");
        int gpa = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Мэргэжил:");
        String major = scanner.nextLine();

        System.out.println("Идэвхтэй эсэх (true/false): ");
        boolean isActive = scanner.nextBoolean();

        System.out.println("=== Бүртгэлийн мэдээлэл ===");
        System.out.println("Нэр:" + name);
        System.out.println("Нас:" + age);
        System.out.println("Курс" + year);
        System.out.println("GPA:"+ gpa);
        System.out.println("Мэргэжил:" +major);
        System.out.println("Идэвхтэй:"+ isActive);

        scanner.close();
    }
}
