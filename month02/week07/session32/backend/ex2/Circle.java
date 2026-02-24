public class Circle extends Shape {
   private double radius;
   
   public Circle(double radius){
    this.radius= radius;
   }

   @Override
   public double area() {
       // TODO Auto-generated method stub
       return 3.15*radius*radius;
   }
}
