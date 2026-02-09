// public class CarFull {
//     public static void main(String[] args) {
//         Car myCar = new Car();
//         myCar.setBrand("Toyota");
//         myCar.setModel("Camry");
//         myCar.setYear(2018);
//         myCar.setCurrentSpeed(0);

//         myCar.displayInfo();

//         myCar.accelerate(50);
//         myCar.accelerate(180);

//         myCar.brake(30);
//         myCar.brake(300);

//         System.out.println("Машин хөдөлж байна уу? " + (myCar.isMoving() ? "Тийм" : "Үгүй"));
//     }
// }
import java.util.Scanner;

public class CarFull {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car myCar = new Car();

        System.out.print("Машины брэнд оруулна уу: ");
        myCar.setBrand(scanner.nextLine());

        System.out.print("Машины модель оруулна уу: ");
        myCar.setModel(scanner.nextLine());

        System.out.print("Машины үйлдвэрлэсэн он оруулна уу: ");
        myCar.setYear(scanner.nextInt());

        myCar.setCurrentSpeed(0);

        myCar.displayInfo();

        System.out.print("Хурдаа нэмэх (км/ц) оруулна уу: ");
        int speedIncrease = scanner.nextInt();
        myCar.accelerate(speedIncrease);

        System.out.print("Дахин хурд нэмэх (км/ц) оруулна уу: ");
        speedIncrease = scanner.nextInt();
        myCar.accelerate(speedIncrease);

        System.out.print("Хурд сааруулах (км/ц) оруулна уу: ");
        int speedDecrease = scanner.nextInt();
        myCar.brake(speedDecrease);

        System.out.print("Дахин хурд сааруулах (км/ц) оруулна уу: ");
        speedDecrease = scanner.nextInt();
        myCar.brake(speedDecrease);

        System.out.println("Машин хөдөлж байна уу? " + (myCar.isMoving() ? "Тийм" : "Үгүй"));

        scanner.close();
    }
}
