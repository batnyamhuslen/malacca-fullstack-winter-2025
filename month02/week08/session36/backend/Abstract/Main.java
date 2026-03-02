package Abstract;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle("red",5);

        Rectangle rec = new Rectangle("black",14, 15);

        Shape[] shapes = {circle1,rec};

        for (Shape s:shapes){
            s.describe();
        }
    }
}
