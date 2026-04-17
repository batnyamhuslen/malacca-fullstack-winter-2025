package mn.icode;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class PrintWritterDemo {
    public static void exer2() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println("Line 1");
            writer.println("Line 2");
            writer.printf("Name: %s, Age: %d%n", "John", 25);
            writer.printf("Price: $%.2f%n", 19.99);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}