import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Насаар ангилал тодорхойлох");
        int score = scanner.nextInt();
      

        if (score < 0 && score > 150) {
            System.out.println("0-150 хооронд байх ёстой!");
        }else if (score<12) {
            System.out.println("Хүүхэд");
        }else if (score>13 && score<19) {
           System.out.println("Өсвөр нас");
        }else if (score>20 && score<59) {
            System.out.println("Насанд хүрэгч");
        }else{
       System.out.println("Ахмад настан");
            
            scanner.close();
        }
    }
}
