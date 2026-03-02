public abstract class Vehicle {
    public String brand;
    public String model;

    public Vehicle(String brand, String model){
        this.brand=brand;
        this.model=model;
    }
    public abstract String fuelType();

    public void describe(){
         System.out.println(brand + " " + model + " " + fuelType());
    } 
}
