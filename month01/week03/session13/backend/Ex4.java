import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       for(int i=1; i<=10; i++){
        if (i==7) {
            break;
        }
        System.out.println(i);
       }
       
       scanner.close();
    }
}
