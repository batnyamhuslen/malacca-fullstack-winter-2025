import java.util.Scanner;

public class Ex8test {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("10 too oruulan uu");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = keyboard.nextInt();
        }

        int positiveSum = 0;
        int negativeSum = 0;
        int zeroCount = 0;

        for (int num : numbers) {
            if (num > 0) {
                positiveSum += num;
            } else if (num < 0) {
                negativeSum += num;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Эерэг тоонуудын нийлбэр: " + positiveSum);
        System.out.println("Сөрөг тоонуудын нийлбэр: " + negativeSum);
        System.out.println("Тэгийн тоо: " + zeroCount);

        keyboard.close();
    }
}
