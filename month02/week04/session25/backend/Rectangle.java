public class Rectangle {
    
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width= width;
        this.height= height;
    }

    public double GetWIDTH(){
        return width;
    }
    public double GetHEIGHT(){
        return height;
    }

    public double calculateAreaRectange(){
        return width*height;
    }
    public double calculatePerimetr(){
        return 2*(width*height);
    }
    public boolean isSquare() {
        return width == height;
    }
    public void displayInfoRectangle(int num){
        System.out.println("=== Rectangle " + num + " ===");
        System.out.println("Хэмжээ: " + width + " x " + height);
        System.out.println("Талбай: " + calculateAreaRectange());
        System.out.println("Периметр: " + calculatePerimetr());
        System.out.println("Квадрат: " + (isSquare() ? "Тийм" : "Үгүй"));
        System.out.println();
    }
}
