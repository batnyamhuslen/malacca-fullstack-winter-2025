import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        for(int i=0; i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }
        numbers.add(10);
        numbers.add(11);
        System.out.println("===================");

        for(int i = 0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
        numbers.set(2, 3);
        System.out.println("===================");
        for(int i = 0; i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }      
        
        numbers.add(0, 0);
        System.out.println("===================");
        for(int i=0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }

        numbers.remove(5);
        System.out.println("====================");
        for(int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
    }
}
