public class Circle extends Shape {
    protected double radius;

    public Circle ( String color, double radius){
        super(color);
        this.radius=radius;

    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimetr() {
        return 2 * Math.PI * radius;
    }

}
