package mn.icode;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class FileWriterExample {
    public static void main(String[] args) {
        BufferedWriter writer=null;
        try{
            writer = new BufferedWriter(new FileWriter("notes.txt", false));
            writer.write("first line");
            writer.newLine();
            writer.write("second line");
            writer.newLine();
            writer.write("thrind line");
            writer.newLine();
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
