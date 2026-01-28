public class Exam1 {
    public static void main(String[] args) {
        printHello();
        printHello();
        printHello();

        greet("ochiroo1");
        greet("ochiroo2");
        greet("ochiroo3");

        printLine(5);
        printLine(10);

    }

    public static void printHello(){
        System.out.println("hello");
    }

    public static void greet(String name){
        System.out.println("hello" + name + "!");
    }

    public static void printLine(int count) {
        for(int i=0; i<count;i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
