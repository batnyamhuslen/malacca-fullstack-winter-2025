public class Ex8 {
    public static void main(String[] args) {
        int[] numbers = {5, -3, 8, -1, 0, -7, 12, 0, -4, 9};

        int positiveSum = 0;
        int negativeSum = 0;
        int zeroCount = 0;

        for (int num : numbers) {
            if (num > 0) {
                positiveSum = num;
            }else if (num < 0) {
                negativeSum = num;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Эерэг тоонуудын нийлбэр: " + positiveSum);
        System.out.println("Сөрөг тоонуудын нийлбэр: " + negativeSum);
        System.out.println("Тэгийн тоо: " + zeroCount);
    }
}
