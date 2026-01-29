public class Ex1 {
    public static void main(String[] args) {
       System.out.println("5 + 3 = " + add(5, 3));           // 8
        System.out.println("10 - 4 = " + hasah(10, 4));    // 6
        System.out.println("6 * 7 = " + multply(6, 7));      // 42
        System.out.println("15 / 4 = " + divide(15, 4));      // 3.75
    }

    public static int add (int a, int b){
        return a+b;
    }

    public static int hasah(int a, int b){
        return a-b;
    }

    public static int multply(int a, int b){
        return a*b;
    }
    public static double divide(int a, int b){
        if (b==0) {
            System.out.println("Error: Cannot divide by zero!");
             return 0;
        }
       return(double) a/b;
    }
}
