
public class Ex1 {
    public static void main(String[] args) {
        int sum=0;

        for(int i = 1; i<=10; i++){
            System.out.println(i);
        }
        for(int i=10;i>=1;i--){
            System.out.println(i);
        }
        for(int i = 5; i<=25;i=i*5){
            System.out.println(i);
        }
        int sum2=0;
        for (int i=1;i<=50;i++){
            sum=sum+1;
        }
        System.out.println("1-50 niilber"+sum);
    }
}
