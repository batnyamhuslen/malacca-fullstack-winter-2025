package mn.icode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadHello {
    public static void main(String[] args) {
        String fileName = "hello.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл олдсонгүй: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Файл уншихад алдаа гарлаа: " + e.getMessage());
        }
    }
}
