import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Цельс (°C):");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 9/5 +32;

        System.out.println(celsius+ "C=" + fahrenheit + "F");
        scanner.close();
        
    }
}
