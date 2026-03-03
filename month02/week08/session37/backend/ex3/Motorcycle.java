public class Motorcycle extends Vehicle{
    public Motorcycle(String brand, String model, int year){
        super(brand, model, year);
    }
    @Override
    public String fuelType() {
        return "petrol";
    }
    @Override
    public int maxSpeed() {
        return 220;
    }
}
