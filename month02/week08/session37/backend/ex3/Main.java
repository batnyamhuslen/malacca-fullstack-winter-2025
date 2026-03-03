public class Main {
    public static void main(String[] args) {
        PetrolCar car = new PetrolCar("toyota", "lc300", 2022);
        ElectricCar elecCar = new ElectricCar("tesla", "Y", 2025, 10000);
        Motorcycle motorcycle = new Motorcycle("yamaha", "zxy", 2019);
        Truck truck = new Truck("volvo", "fh", 2014, 44000);

        Vehicle[] Vehicles = { car, elecCar, motorcycle, truck };

        System.out.println("=======================================");
        System.out.println("All vehicle");
        System.out.println("----------------------------------------");
        for (Vehicle a : Vehicles) {
            a.getInfo();
        }

        System.out.println("========================================");
        System.out.println("Modern vehicles 2020+:");
        System.out.println("----------------------------------------");
        for (Vehicle a : Vehicles) {
            if (a.isModern()) {
                a.getInfo();
            }
        }

        System.out.println("=========================================");
        System.out.println("Fastest vehicles");
        System.out.println("-----------------------------------------");
        Vehicle fastest = Vehicles[0];
        for (Vehicle a : Vehicles) {
            if (a.maxSpeed() > fastest.maxSpeed()) {
                fastest = a;
            }
        }
        fastest.getInfo();
    }
}
