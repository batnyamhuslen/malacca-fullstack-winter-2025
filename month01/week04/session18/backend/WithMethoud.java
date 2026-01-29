
public class WithMethoud {
    public static void main(String[] args) {
        printAverge("student1", 0, 0, 0);
        printAverge("student2", 0, 0, 0);
        printAverge("student3", 0, 0, 0);
    }

    public static void printAverge(String name, int a, int b, int c){
        double avg = (a+b+c) /3.0;
        System.out.println(name + "average" +avg);
    }
}
