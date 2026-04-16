package mn.icode;

import java.util.List;

public class Exercise4 {
    public static void processNumbers(String filename) {
        List<String> lines = Exercise2.readAllLines(filename);

        if (lines.isEmpty()) {
            System.out.println("File is empty or not found.");
            return;
        }

        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String line : lines) {
            if (line.trim().isEmpty())
                continue;

            try {
                int num = Integer.parseInt(line.trim());

                sum += num;
                count++;

                if (num > max)
                    max = num;
                if (num < min)
                    min = num;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + line);
            }
        }

        if (count == 0) {
            System.out.println("No valid numbers found.");
            return;
        }

        double average = (double) sum / count;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
