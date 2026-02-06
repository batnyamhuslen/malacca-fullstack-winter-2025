import java.security.PublicKey;

public class Circle {
    private String color;
    private double radius;
    public static final double PI = 3.14159;

    public Circle (double radius,String color){
        this.color = color;
        this.radius = radius;
    }

    public String getColor(){
        return color;
    }

    public double getRadius(){
        return radius;
    }

    public double calculateArea(){
        return PI * radius * radius;
    }

    public double calculateCircumference(){
        return 2 * PI * radius;
    }

    public void displayInfoCircle(){
        System.out.println("unguu "+color);
        System.out.println("radius "+ radius);
    }

}
