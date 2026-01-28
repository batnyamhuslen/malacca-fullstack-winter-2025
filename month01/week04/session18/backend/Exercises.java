public class Exercises {
    public static void main(String[] args) {
        greet("huslen");

        int result= add(5,3);
        System.out.println("Sum"+result);

        System.out.println(isOdd(5));
        System.out.println(isOdd(4));

        int[] numbers = {10,20,30,40,50};
        System.out.println("sum"+ sum(numbers));

    }

    public static void greet(String name){
        System.out.print("Hello" + name + "!");
    }

    public static int add(int a,int b){
        int result= a+b;
        return result; 
    }
    
    public static boolean isOdd(int num){
        return num%2==0;
    }
    public static int sum(int[]arr){
        int total = 0;
        for(int num:arr){
            total=total+num;
        }
        return total;
    }

}
 