package mn.icode;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("алим");
        fruits.add("жүрж");
        fruits.add("тавгар лийр");
        fruits.add("усан үзэм");
        fruits.add("ломбо");
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println(fruits.get(0));
        System.out.println(fruits.get(fruits.size()-1));
        fruits.contains("жүрж");
        System.out.println(fruits);
        fruits.remove("тавгар лийр");
        System.out.println(fruits);
        ArrayList<String> colors = new ArrayList<>();
        colors.add("улаан");
        colors.add("ногоон");
        colors.add("цэнхэр");
        colors.add("шар");
        colors.add("ягаан");
        colors.indexOf("цэнхэр");
        System.out.println(colors);
    }
}
