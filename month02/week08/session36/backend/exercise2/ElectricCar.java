public class ElectricCar extends Vehicle{

    public ElectricCar(String brand, String model) {
    super(brand, model);
    }

     @Override
    public String fuelType() {
        return "elec";
    }
}
