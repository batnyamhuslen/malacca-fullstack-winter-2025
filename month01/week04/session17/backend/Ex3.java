public class Ex3 {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 95, 88, 76, 90};

        // 1. Нийлбэр олох
        int sum = 0;
        for (int score :scores) {
            sum = sum + score;
        }
        System.out.println("Нийлбэр: " + sum);

        // 2. Дундаж олох (double хэлбэрээр)
        double average = (double) sum / scores[i];
        System.out.println("Дундаж: " + average);

        // 3. Дундаж 2 орон нарийвчлалтай хэвлэх
        System.out.printf("Дундаж (2 орон): %.2f%n", average);
    }
}
