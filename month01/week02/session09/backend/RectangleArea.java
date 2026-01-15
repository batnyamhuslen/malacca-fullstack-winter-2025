import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Урт");
        float length = scanner.nextFloat();

        System.out.println("Өргөн");
        double width = scanner.nextDouble();

        double area = length * width;
        System.out.println("Талбай" + area);
        
        scanner.close();
    }
}
