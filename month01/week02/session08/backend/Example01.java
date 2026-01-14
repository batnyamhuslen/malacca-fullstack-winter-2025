import java.util.Scanner;

public class Example01 {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Give me your name ");

      String name = scanner.nextLine();
      System.out.println("you name is "+ name);

      System.out.println("give me your age");
      int age = scanner.nextInt();
      System.out.println("your age is:" + age);

      scanner.close();
      

    }
}
