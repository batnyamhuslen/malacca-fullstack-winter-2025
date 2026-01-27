import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String[] student = {"Бат", "Болд", "Дорж", "Сүхээ", "Төгс"};

        System.out.println("Хайх нэр оруулна уу:");
        String searchName = keyboard.nextLine();

        int foundIndex = -1; 
        for(int i = 0; i < student.length; i++){
            if (student[i].equals(searchName)) {
                foundIndex = i; 
            }
        }

        if (foundIndex != -1) {
            System.out.println(searchName + "олдлоо! Index:" + foundIndex);
        }else{
            System.out.println(searchName + "олдсонгүй");
        }

        keyboard.close();
    }
}
