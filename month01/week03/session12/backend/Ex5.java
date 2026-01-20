import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оноо Үнэлгээний Систем");
        System.out.println("Оноо оруулна уу (0-100):");
        int score = scanner.nextInt();
        String grade = "";
        String gradeText = "";

        if (score < 0 || score > 100) {
            System.out.println("Алдаа: Оноо 0-100 хооронд байх ёстой!");
        } else {
            if (score >= 90) {
                grade = "A";
                gradeText = "Onts!!!";
            } else if (score >= 80) {
                grade = "B";
                gradeText = "sain";
            } else if (score >= 70) {
                grade = "C";
                gradeText = "dund";
            } else if (score >= 60) {
                grade = "D";
                gradeText = "need tn improve";
            } else {
                grade = "F";
                gradeText = "very bad";
            }
            System.out.println("=== Үр дүн ===");
            System.out.println(score);
            System.out.println("Оноо: " + grade);
            System.out.println("Unelgee: " + gradeText);
            System.out.println();
        }

        scanner.close();
    }
}
