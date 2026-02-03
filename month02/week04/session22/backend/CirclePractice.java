class Circle {
    double radius;
    String color;
    double PI = 3.14159;

    public Circle(double r, String c) {
        radius = r;
        color = c;
    }

    public void displayCircleInfo() {
        double area = PI * radius * radius;
        double circumference = 2 * PI * radius;

        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│ === Circle 1 ===                    │");
        System.out.printf("│ Өнгө: %s                         │\n", color);
        System.out.printf("│ Радиус: %.1f                         │\n", radius);
        System.out.printf("│ Талбай: %.2f                       │\n", area);
        System.out.printf("│ Тойрог: %.2f                       │\n", circumference);
        System.out.println("└─────────────────────────────────────┘");
    }

}

public class CirclePractice {
    public static void main(String[] args) {
Circle circle1 = new Circle(5.0, "Улаан");
        Circle circle2 = new Circle(3.0, "Ногоон");

        // Мэдээллийг харуулах
        circle1.displayCircleInfo();
        circle2.displayCircleInfo();

        // Харьцуулах (талбай, тойрог)
        if (circle1.PI * circle1.radius * circle1.radius > circle2.PI * circle2.radius * circle2.radius) {
            System.out.println("Circle 1-ийн талбай Circle 2-оос их байна.");
        } else if (circle1.PI * circle1.radius * circle1.radius < circle2.PI * circle2.radius * circle2.radius) {
            System.out.println("Circle 2-ийн талбай Circle 1-ээс их байна.");
        } else {
            System.out.println("Circle 1 болон Circle 2-ийн талбай адил байна.");
        }

        if (2 * circle1.PI * circle1.radius > 2 * circle2.PI * circle2.radius) {
            System.out.println("Circle 1-ийн тойрог Circle 2-оос урт байна.");
        } else if (2 * circle1.PI * circle1.radius < 2 * circle2.PI * circle2.radius) {
            System.out.println("Circle 2-ийн тойрог Circle 1-ээс урт байна.");
        } else {
            System.out.println("Circle 1 болон Circle 2-ийн тойрог адил байна.");
        }
    }
}
