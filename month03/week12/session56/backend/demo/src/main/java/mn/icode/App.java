package mn.icode;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.mn.icode.Student;

public class App {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("oyuns");
        names.add("bat");
        names.add("anu");
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.get(1));
        names.contains("bat");
        System.out.println(names);
        names.remove("oyuns");
        System.out.println(names);
        names.forEach(i->System.out.println(i));

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i =1;i<=10;i++){
            numbers.add(i);
        }
        System.out.println(numbers);
        System.out.println(numbers.get(3));
        numbers.set(0,100);
        System.out.println(numbers);
       int sum = 0;
        // numbers.forEach(i->sum=+i);
        for(int el:numbers){
            sum+=el;
        }
        System.out.println(sum);
    }
}
