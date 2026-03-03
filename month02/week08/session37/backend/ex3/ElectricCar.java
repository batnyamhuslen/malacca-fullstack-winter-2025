public class ElectricCar extends Vehicle{
    int batteryKwh;
    public ElectricCar(String brand, String model, int year,int batteryKwh){
        super(brand,model,year);
        this.batteryKwh=batteryKwh;
    }

    @Override
    public String fuelType() {
        return "elec";
    }

    @Override
    public int maxSpeed() {
        return 250;
    }    
}
