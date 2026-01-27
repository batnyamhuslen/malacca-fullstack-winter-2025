public class Ex3 {
    public static void main(String[] args) {
        int [] numbers ={23,45,12,67,34,89,5};
        int max = numbers[0];

        for(int i=1; i<numbers.length;i++){
            if(numbers[i]> max){
                max= numbers[i];
            }
        }
        System.out.println("Хамгийн их:" +max);


        int min = numbers[0];

        for(int i=1; i<numbers.length; i++){
            if (numbers[i]<min) {
                min=numbers[i];
            }
        }
        System.out.println("hamgiin baga n " + min);

    }
}
