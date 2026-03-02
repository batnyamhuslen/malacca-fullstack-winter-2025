package Abstract;
public abstract class Shape {
    protected String color;

    public Shape (String color){
        this.color=color;
    }

    public abstract double area();

    public abstract double perimeter();


    public void describe(){
        System.out.printf("%s [%s] area= %.2f%n",getClass().getSimpleName(), color , area());
    }
}
