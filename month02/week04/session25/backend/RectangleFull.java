import java.util.Scanner;

public class RectangleFull {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("RECTANGLE 1");
        System.out.println("urgun oruulan uu!");
        double garasWidth = keyboard.nextDouble();
        System.out.println("undur oruulan uu!");
        double garasHeight = keyboard.nextDouble();

        Rectangle rectangle1 = new Rectangle(garasWidth, garasHeight);
        
        System.out.println("RECTANGLE 2");
        System.out.println("urgun oruulan uu!");
        double garasWidth2 = keyboard.nextDouble();
        System.out.println("undur oruulan uu!");
        double garasHeight2 = keyboard.nextDouble();

        Rectangle rectangle2 = new Rectangle(garasWidth2, garasHeight2);
        
        rectangle1.displayInfoRectangle(1);
        rectangle2.displayInfoRectangle(2);

        keyboard.close();
    }
}
