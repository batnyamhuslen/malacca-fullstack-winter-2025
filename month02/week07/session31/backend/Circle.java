public class Circle extends Shape {
    private double radius;

    public Circle( double radius,String color){
        super(color);
        this.radius=radius;
    }
    @Override
    public void printInfo() {
        // TODO Auto-generated method stub
        System.out.println("Circle has "+" " + color + " "+"color "+ "width "+ radius + " cm");
    }
}
