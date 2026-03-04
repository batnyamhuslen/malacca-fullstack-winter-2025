import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //1. String ArrayList үүсгэж, 5 нэр нэм, бүгдийг хэвлэ
        // ArrayList<String> names = new ArrayList<>();
        // names.add("bat");
        // names.add("sara");
        // names.add("dorj");
        // names.add("ochiroo");
        // names.add("khuslen");
        // for(String name:names){
        // System.out.println(name);
        // }

        //2. Integer ArrayList-д 10 тоо нэм, нийлбэр ол
        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(3);
        // numbers.add(4);
        // numbers.add(5);
        // numbers.add(6);
        // numbers.add(7);
        // numbers.add(8);
        // numbers.add(9);
        // numbers.add(10);
        // int sum=0 ;
        // for(int i:numbers){
        // sum+=i;
        // }
        // System.out.println(sum);

        //3. 3-р элементийг өөрчлөх, устгах
        // ArrayList<String> names = new ArrayList<>();
        // names.add("khuslen");
        // names.add("dorj");
        // names.add("ochiroo");
        // names.add("marlaa");
        // names.remove("ochiroo");
        // for (String name : names) {
        //     System.out.println(name);
        // }

        //4.  ArrayList доторх "Banana" байгааг шалга (contains)
        ArrayList<String> names = new ArrayList<>();
        names.add("apple");
        names.add("banana");
        names.add("strawberry");
        names.add("granade");
        System.out.println(names.contains("banana"));


    }
}
