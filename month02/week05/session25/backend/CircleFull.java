import java.util.Scanner;

public class CircleFull {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("ungu oruulna u");
        String garasUngu = keyboard.nextLine();

        System.out.println("radius oruulah");
        double garasRaduis = keyboard.nextDouble();

        Circle circle1 = new Circle(garasRaduis, garasUngu);

        System.out.println("calculate area");
        System.out.println(circle1.calculateArea());
        System.out.println("calulateCircumference");
        System.out.println(circle1.calculateCircumference());
        circle1.displayInfoCircle();
        keyboard.close();
    }
}
