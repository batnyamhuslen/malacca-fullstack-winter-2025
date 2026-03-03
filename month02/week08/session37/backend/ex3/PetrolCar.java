public class PetrolCar extends Vehicle{
    public PetrolCar(String brand, String model, int year){
        super(brand, model, year);
    }

    @Override
    public String fuelType() {
        return "Petrol";
    }

    @Override
    public int maxSpeed() {
        return 180;
    }
}
