import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хэдэн гишүүн хэвлэх вэ");
        int n = scanner.nextInt();
        int a = 0;
        int b= 1;

        System.out.println(a + "" +b + "");
        for(int i = 3; i<=n;i++){
            int next = a + b;
            System.out.println(next+ "");
            a=b;
            b=next;
        }
        scanner.close();
    }
}
