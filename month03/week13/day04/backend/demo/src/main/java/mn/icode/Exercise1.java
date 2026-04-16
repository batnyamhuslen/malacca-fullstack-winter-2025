package mn.icode;
import java.io.File;

public class Exercise1 {
    public static void getFileInfo(String filename){
         File file = new File(filename);

        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        if (file.exists()) {
            System.out.println("File exists: Yes");
            System.out.println("File size: " + file.length() + " bytes");
        } else {
            System.out.println("File exists: No");
        }
        System.out.println("----------------------");
    }
}
