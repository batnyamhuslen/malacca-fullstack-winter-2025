import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n;i=i+1){
            
          if (i%2==0) {
            System.out.println(i+"tegsh");
          }

        }
        sc.close();
    }
}
