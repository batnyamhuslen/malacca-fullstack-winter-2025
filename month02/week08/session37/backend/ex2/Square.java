class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimetr() {
        return 4 * side;
    }
}
