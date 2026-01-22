import java.util.Scanner;

public class PrintNToOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum=0;

        for(int i=1; i<=n;i++){
             sum=sum+1;
             System.out.println(i);

        }scanner.close();
    }
}
