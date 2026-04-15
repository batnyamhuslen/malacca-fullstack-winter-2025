package mn.icode;

import java.io.File;

public class FileExercise {
    public static void runExercise() { 
        File myFile = new File("data.txt");

        if (myFile.exists()) {
            System.out.println("File байна!");
        }

        if (myFile.isFile()) {
            System.out.println("Энэ бол файл");
        } else if (myFile.isDirectory()) {
            System.out.println("Энэ бол директор");
        }

        System.out.println("Нэр: " + myFile.getName());
        System.out.println("Хэмжээ: " + myFile.length() + " bytes");
    }
}