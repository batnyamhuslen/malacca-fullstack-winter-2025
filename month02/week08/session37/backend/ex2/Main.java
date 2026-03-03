public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("red", 5);
        Rectangle rec = new Rectangle("blue", 5, 10);
        Triangle tri = new Triangle("purple", 3, 10, 7);
        Square sq = new Square("pink", 2);

        Shape[] shapes = {circle,rec,tri,sq};

        for (Shape shape: shapes){
            shape.printInfo();
        }
    }
}
