package month01.week03.session13.backend;

public class Loops2 {
    public static void main(String[] args) {
        int count = 1;
        int sum=0;

        while (count<=100) {
           
            sum=sum+count;
            count=count+1;
        }
        System.out.println(sum);
    }
}
