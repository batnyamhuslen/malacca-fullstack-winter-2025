package mn.icode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<String[]> read(String filePath) {
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                rows.add(values);
            }

        } catch (IOException e) {
            throw new RuntimeException("CSV file уншихад алдаа гарлаа: " + filePath, e);
        }

        return rows;
    }
}
