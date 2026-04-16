package mn.icode;

import java.util.List;

public class Exercise3 {
    public static void countLinesAndWords(String filename) {
        List<String> lines = Exercise2.readAllLines(filename);

        int totalLines = lines.size();
        int totalWords = 0;
        int nonEmptyLines = 0;

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                nonEmptyLines++;

                String[] words = line.trim().split("\\s+");
                totalWords += words.length;
            }
        }
        System.out.println("----------------------");
        System.out.println("exer3");
        System.out.println("Total lines: " + totalLines);
        System.out.println("Total words: " + totalWords);
        System.out.println("Non-empty lines: " + nonEmptyLines);
        System.out.println("----------------------");
    }
}