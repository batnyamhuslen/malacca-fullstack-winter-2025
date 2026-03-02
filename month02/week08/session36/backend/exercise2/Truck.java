public class Truck extends Vehicle {

    public Truck(String brand, String model ){
        super(brand, model);
    }
     @Override
    public String fuelType() {
        return "Diesel";
    }
}
