package mn.icode;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileNumberWriter {
    public static void main(String[] args) {
        BufferedWriter writer=null;
        try{
            writer = new BufferedWriter(new FileWriter("numbers.txt", false));
            for(int i = 0; i<100; i++){
                writer.write(String.valueOf(i));
                writer.newLine();
            }
            System.out.println("file successfully written");
        }catch(Exception e){
            System.out.println("Error occurred" + e.getMessage());
        }finally{
            if (writer != null) {
                try{
                    writer.close();
                }catch(Exception e){
                    System.out.println("error during file close"+ e.getMessage());
                }
            }
        }
    }
}
