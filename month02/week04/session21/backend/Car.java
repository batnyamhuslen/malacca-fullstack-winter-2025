public class Car {
    // Fields (instance variables)
    String brand;
    String model;
    int year;
    String color;

    // Methods
    void start() {
        System.out.println(brand + " " + model + " started!");
    }

    void stop() {
        System.out.println(brand + " " + model + " stopped!");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
    }
}

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







