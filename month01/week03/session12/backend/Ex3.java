import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("ehnii too");
    int num1 =scanner.nextInt();
    System.out.println("2dh too");
    int num2 =scanner.nextInt();
    System.out.println("3dh too");
    int num3 = scanner.nextInt();

    if (num1 >=num2 && num1 >=num3) {
        System.out.println("хамгийн их" + num1);
    }else if (num2>=num3) {
        System.out.println("хамгийн их"+num2);
    }else
        System.out.println("хамгийн их"+ num3);
        scanner.close();
    }
}