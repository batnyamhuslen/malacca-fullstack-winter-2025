import java.util.Scanner;

public class Multipleinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("student regis:");
        
        System.out.println("name: ");
        String name = scanner.nextLine();

       
        System.out.println("age: ");
        int age = scanner.nextInt();

        System.out.println("GPA: ");
        double gpa = scanner.nextDouble();

        System.out.println("is active true,false: ");
        boolean student = scanner.nextBoolean();

        System.out.println("height");
        float height = scanner.nextFloat();

        System.out.println(".....................");
        System.out.println("Output");
        System.out.println("Name: " + name);
        System.out.println("age " + age);
        System.out.println("gpa " +gpa);
        System.out.println("is active " + student);
        System.out.println("height "+ height);

        scanner.close();
    }
}
