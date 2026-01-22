import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum=0;
      
    for (int i = 1; i<=n; i=i+1){
        sum=sum+i;  
    } 
         System.out.println(sum);
    sc.close();
    }
}
