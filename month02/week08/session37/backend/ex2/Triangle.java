class Triangle extends Shape {
    private double base, height, hypotenuse;

    public Triangle(String color, double base, double height, double hypotenuse) {
        super(color);
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimetr() {
        return base + height + hypotenuse;
    }
}
