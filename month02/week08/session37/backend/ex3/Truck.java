public class Truck extends Vehicle {
    int payLoadTons;
    public Truck(String brand, String model, int year, int payLoadTons){
        super(brand, model, year);
        this.payLoadTons=payLoadTons;
    }

    @Override
    public String fuelType() {
        return "Diesel";
    }

    @Override
    public int maxSpeed() {
        return 120;
    }
}
