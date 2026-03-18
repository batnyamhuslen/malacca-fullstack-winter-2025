package mn.icode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class InputWriter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BufferedWriter writer=null;
        try{
            writer = new BufferedWriter(new FileWriter("inputText.txt", false));
            
            System.out.println("name oruul");
            String first = keyboard.next();
            System.out.println("utas oruul");
            String second =  keyboard.next();
            System.out.println("hayag oruul");
            String third = keyboard.next();

            writer.write(first);
            writer.newLine();
            writer.write(second);
            writer.newLine();
            writer.write(third);
            
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
