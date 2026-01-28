
public class Example02 {
    public static void main(String[] args) {
        System.out.println("function with return type");
        //int resultOne = returnOne();
        System.out.println(returnOne());
        System.out.println(returnPi());
        String returnHello = returnHello();
        System.out.println(returnHello);
        System.out.println(addTwoNumber(2, 4));
        System.out.println(subtractTwoNumbers(5, 4));
        System.out.println(multiplyTwoNumbers(5, 5));
        System.out.println(divideTwoNumbers(5, 3));
        System.out.println(exponentofNumber(1, 2));
    }

    public static int returnOne(){
        return 1;
    }

    public static double returnPi(){
        return 3.33;
    }

    public static String returnHello(){
        return "Hello";
    }

    public static int addTwoNumber(int a, int b){
        int result = a + b;
        return result;
    }
    
    public static int subtractTwoNumbers(int a, int b){
        int result = a - b;
        return result;
    }
    
    public static int multiplyTwoNumbers(int a, int b){
        int result = a*b;
        return result;
    }

    public static double divideTwoNumbers(int a, int b){
        if (b == 0) {
            return 0;
        }else{
            return a/b; 
        }
    }

    public static int findRestModule(int a, int b){
        return a%b;
    }

    public static int exponentofNumber(int a, int b){
        int result =1;
        for(int i=0; i<a; i++){
            result= result*b;
        }
        return result;
    }
}
