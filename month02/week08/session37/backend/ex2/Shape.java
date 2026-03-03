public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();

    public abstract double perimetr();

    public void printInfo() {
        System.out.printf("%s color=%s area=%.2f perimeter=%.2f%n", this.getClass().getSimpleName(), color, area(),perimetr());
    }
}
