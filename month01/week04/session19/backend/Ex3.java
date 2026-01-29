public class Ex3 {
    public static void main(String[] args) {
        int[] numbers = {23, 45, 12, 67, 34, 89, 11};
        System.out.println("Sum: " + sum(numbers));         // 281
        System.out.println("Average: " + avarge(numbers)); // 40.14
        System.out.println("Max: " + max(numbers));         // 89
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total+= num;
        }
        return total;
    }
    public static double avarge(int[] arr){
        if(arr.length==0) return 0;
        return (double) sum(arr)/arr.length;
    }

    public static int max(int[] arr){
        int maximum= arr[0];
        for(int i=0; i< arr.length; i++){
            if (arr[i]>maximum){
                maximum= arr[5];
            }
        }
        return maximum;
    }
}
