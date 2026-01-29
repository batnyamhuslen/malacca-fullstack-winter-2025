public class Ex4 {
    public static void main(String[] args) {
        System.out.println("add(5, 3) = " + add(5, 3));         // 8
        System.out.println("add(5, 3, 2) = " + add(5, 3, 2));   // 10
        System.out.println("add(5.5, 3.5) = " + add(5.5, 3.5)); // 9.0
    }
    public static int add(int a, int b){
        return a + b; 
    }

    public static double add(double a, double b){
        return a + b; 
    }

    public static int add(int a, int b, int c){
        return a+b+c;
    }

    public static int add(int[] numbers){
        int total = 0;
        for(int num:numbers){
            total+=num;
        }
        return total;
    }
}

