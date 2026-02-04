public class Main {
    public static void main(String[] args) {
        // Object үүсгэх
        Car myCar = new Car();

        // Fields-д утга өгөх
        myCar.brand = "Toyota";
        myCar.model = "Camry";
        myCar.year = 2023;
        myCar.color = "Black";

        // Methods дуудах
        myCar.displayInfo();
        myCar.start();
        myCar.stop();
    }
}
