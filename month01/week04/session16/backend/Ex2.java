
public class Ex2 {
    public static void main(String[] args) {
        int [] scores = {85,90,78,92,88};

        int sum=0;

        for (int score : scores){
            sum=sum+score;
        }
        System.out.println("Нийлбэр:" +sum);

        double average =  (double)sum / scores.length;
        System.out.println("dundaj"+ average);
    }
}
