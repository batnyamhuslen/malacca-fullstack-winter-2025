package Abstract;
public class Circle extends Shape{
    protected double radius;
    
    public Circle (String color, double radius){
        super(color);
        this.radius=radius;
    }

    @Override
    public double area(){
        return 3.14*radius*radius;
    }
    public double perimeter(){
        return 2*3.14*radius;
    }

}
