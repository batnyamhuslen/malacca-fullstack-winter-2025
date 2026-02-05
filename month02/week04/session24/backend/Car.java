public class Car {
    private String brand;
    private String model;
    private int year;
    private int currentSpeed;

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void accelerate(int amount) {
        currentSpeed += amount;
        if (currentSpeed > 200) {
            currentSpeed = 200;
        }
        System.out.println("Хурдасгалаа. Одоогийн хурд: " + currentSpeed + " км/ц");
    }
    
    public void brake(int amount) {
        currentSpeed -= amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        System.out.println("Хурд саарлаа. Одоогийн хурд: " + currentSpeed + " км/ц");
    }

    public int getAge() {
        return 2025 - year;
    }

    public boolean isMoving() {
        return currentSpeed > 0;
    }

    public void displayInfo() {
        System.out.println("Брэнд: " + brand);
        System.out.println("Загвар: " + model);
        System.out.println("Үйлдвэрлэсэн он: " + year);
        System.out.println("Одоогийн хурд: " + currentSpeed + " км/ц");
        System.out.println("Машины нас: " + getAge() + " жил");
        System.out.println("Хөдөлж байна уу? " + (isMoving() ? "Тийм" : "Үгүй"));
    }
}
