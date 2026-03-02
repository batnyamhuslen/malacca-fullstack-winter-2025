public class Car extends Vehicle {

    public Car( String brand, String model){
        super(brand, model);
    }
     @Override
    public String fuelType() {
        return "Petrol";
    }

}
