public class Triangle extends Shape {
    private double heigth;
    private double base;

    public Triangle( double heigth, double base ,String color){
        super(color);
        this.heigth=heigth;
        this.base=base;
    }
    @Override
    public void printInfo() {
        // TODO Auto-generated method stub
        System.out.println("triagnle has"+" "+color+" " + heigth +" " + "height" + " "+base+" "+ "base");
    }
}
