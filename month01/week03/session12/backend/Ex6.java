import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sar = scanner.nextInt();

        if (sar < 1 || sar > 12 ) {
            System.out.println("буруу сар");
        }else if (sar==12 || sar ==1 || sar ==2 ) {
            System.out.println("бол өвөл");
        }else if (sar>=6&& sar <=8) {
            System.out.println("зун");
        }
        scanner.close();
    }
}
