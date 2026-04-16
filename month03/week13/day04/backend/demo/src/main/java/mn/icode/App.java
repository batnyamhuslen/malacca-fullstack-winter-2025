package mn.icode;
import java.util.List;
public class App {
    public static void main( String[] args ){
        Exercise1.getFileInfo("employees.txt");
        Exercise1.getFileInfo("nonexistent.txt");
        List<String> lines = Exercise2.readAllLines("employees.txt");
        System.out.println("Total lines: " + lines.size());
        lines.forEach(System.out::println);
        Exercise3.countLinesAndWords("employees.txt");
        Exercise4.processNumbers("numbers.txt");
    }
}

