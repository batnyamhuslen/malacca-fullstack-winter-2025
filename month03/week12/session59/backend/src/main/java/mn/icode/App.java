package mn.icode;
import java.util.Map;
import java.util.HashMap;

public class App 
{
    public static void main( String[] args ){
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Болд", 22);
        ages.put("Оюун", 20);
        ages.put("Бат", 25);
        ages.put("Ану", 19);
        ages.put("Тэмүр", 23);
        System.out.println(ages.get("Болд"));
        System.out.println(ages.containsKey("Бат"));
        ages.put("Оюун", 21);
        System.out.println(ages.get("Оюун"));
        ages.remove("Тэмүр");
        System.out.println(ages);
    }
}
