public class Exercise5 {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 90, 88};
        printReport("Alice", scores);
    }

    public static double calculateAverage(int[] scores){
        if(scores.length == 0) return 0;
        int total = 0;
        for(int score : scores){
            total += score;
        }
        return (double) total / scores.length;
    }

    public static String getLetterGrade(double average){
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public static boolean isPassing(double average){
        return average >= 60;
    } 

    public static void printReport(String name, int[] scores){
        System.out.println("Name: " + name);
        double avg = calculateAverage(scores);
        System.out.printf("Average: %.2f%n", avg);
        System.out.println("Grade: " + getLetterGrade(avg));
        System.out.println("Status: " + (isPassing(avg) ? "PASSED" : "FAILED"));
    }
}
