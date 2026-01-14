import java.util.Scanner;


public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nas");
        int age = scanner.nextInt();
        scanner.nextLine();        
     
        
        System.out.println("ner");
        String name = scanner.nextLine();

        System.out.println("nas " + age );
        System.out.println("ner " + name);
        
        scanner.close();

    }
}
