public abstract class Vehicle {
    String brand, model;
    int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public abstract String fuelType();

    public abstract int maxSpeed();

    public void getInfo() {
        System.out.println("on " + year +" "+ model + " "+fuelType() +"      "+ "deed hurd:" + maxSpeed()+"km/h");
    }

    public boolean isModern() {
        return year >= 2020;
    }
}
