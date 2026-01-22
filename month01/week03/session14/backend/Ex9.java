import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хүснэгтийн хэмжээ:");
        int n =scanner.nextInt();

        for(int i = 1; i<=n; i++){

            for(int j = 1; j<=n; j++){
                System.out.printf("%15d",i*j);
            }
            System.out.println();
            System.out.println();
          
        }
        scanner.close();
    }
}
