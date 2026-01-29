public class Ex2 {
    public static void main(String[] args) {
          System.out.println("Is 7 prime? " + isPrime(7));    
        System.out.println("Is 10 prime? " + isPrime(10));  
        System.out.println("Is 17 prime? " + isPrime(17)); 
    }

    public static boolean isPrime(int num){
        if(num<=1) return false;
        if(num == 2) return true;
        if(num%2==0) return false;

        for (int i=3; i*i<=num; i+=2){
            if (num%2==0) {
            }
            return false;
        }
        return true;
    }
}
