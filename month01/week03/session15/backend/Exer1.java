import java.util.Scanner;

import java.util.Random;

public class Exer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String playAgian = "y";

        System.out.println("=============================");
        System.out.println("        ТОО ТААХ ТОГЛООМ");
        System.out.println("=============================");

       
        while (playAgian.equalsIgnoreCase("y")) {

            int secretNumber = random.nextInt(100) + 1;  //1-100 iin hoorond random objectiin variable n 
            int guess;      //buhel too turultei taawarin variable
            int attempts = 0;    //oroldlogo buhen too n turultei  

            System.out.println("1-100 хооронд тоо сонголоо. Таагаарai"); 

        //do while dawtalt ehleh heseg
        do{
            System.out.println("Таамаг оруулна уу:");
            guess = scanner.nextInt();    //taawarin toog garas awah 
            attempts++;    // oroldlogo nemed hadgalah

            
            //taawariing too n garas awah toonos baga baih shalgah
            if (guess<secretNumber) { 
                System.out.println("Их тоо оруул!");
            }else if (guess>secretNumber) {
                System.out.println("Бага тоо оруул!");
            }

        //garas awsan too n taawrin tootoi tentsku bol DO hesgiig dawtana
        }while(guess != secretNumber); 
        // taawrin too garas awsan too tentsuul hewlene 
        System.out.println("Зөв таалаа!");
        System.out.println("Оролдлого:"+ attempts);    //++attemps oroldlogo hadgalsang haruulna


        //hadgalsan oroldlogoo 5aas, 10aas, baga baina uu gej shalgad hewleh (else busad ued hewleh n)
        if (attempts<=5) {
            System.out.println("Маш сайн!"); 
        }else if (attempts<=10){ 
            System.out.println("Сайн!");
        }else{
            System.out.println("Дараа дахин оролд!");
        }
        
        //dawtaltan dotroo hewlej haruulad PlayAgian variabl n String turultei "y" hadgalsan 
        System.out.println("Дахин тоглох уу? (y/n)");
        
        //scaneraar whiliin ehni hesegruu shiljih 
        playAgian = scanner.next(); 
       }

       //loopni gadaa main dotroo hewelsen n 
        System.out.println("Баярлалаа! Баяртай!");
        scanner.close();
    }
}

