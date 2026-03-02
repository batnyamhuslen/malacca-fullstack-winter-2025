public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck("volvo", "truck");
        Car car = new Car("porsche", "911");
        ElectricCar electron = new ElectricCar("tesla", "y");

        Vehicle[] vehicles = {truck,car,electron};

        for (Vehicle a: vehicles){
            a.describe();
        }
    }    
}
