public class Main {
    public static void main(String[] args) {
        // Object үүсгэх
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2023;
        car1.color = "Black";

        Car car2 = new Car();
        car2.brand = "toyota";
        car2.model = "lc300";
        car2.year = 2026;
        car2.color = "white";

        Car car3 = new Car();
        car3.brand = "lexus";
        car3.model = "lx570";
        car3.year = 2020;
        car3.color = "black";
        
        car1.displayInfo();
        car1.start();
        car1.stop();
        System.out.println("---");
        car2.displayInfo();
        car2.start();
        car2.stop();
        System.out.println("---");
        car3.displayInfo();
        car3.start();
        car3.stop();
    }
    
}
