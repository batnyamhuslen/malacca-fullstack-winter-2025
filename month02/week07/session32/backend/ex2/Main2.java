public class Main2 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(8, 5);

        System.out.printf("Circle area: %.2f\n", circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
    }
}
