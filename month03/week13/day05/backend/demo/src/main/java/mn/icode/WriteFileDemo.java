package mn.icode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDemo {
    public static void exer1() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is line 2.");

            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
