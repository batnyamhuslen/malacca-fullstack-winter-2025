import java.util.Scanner;
import java.util.Arrays;

public class ArrayProcessor {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int [] numbers = {23,45,12,67,34,89,11};
        int choise;
        do{
            printMenu();
            choise = keyboard.nextInt();
            
            switch (choise) {
                case 1:
                    System.out.println("Current Array:");
                    printArray(numbers);
                    break;
                case 2:
                    System.out.print("Enter element to add: ");
                    int newElement = keyboard.nextInt();
                    numbers = addElement(numbers, newElement);
                    System.out.println("Element added!");
                    printArray(numbers);
                    break;
                case 3:
                    System.out.print("Enter index to remove: ");
                    int index = keyboard.nextInt();
                    numbers = removeElement(numbers, index);
                    System.out.println("Element removed!");
                    printArray(numbers);
                    break;
                case 4:
                    System.out.println("Sum: " + sum(numbers));
                    break;
                case 5:
                    System.out.printf("Average: %.2f%n", average(numbers));
                    break;
                case 6:
                    System.out.println("Maximum: " + max(numbers));
                    break;
                case 7:
                    System.out.println("Minimum: " + min(numbers));
                    break;
                case 8:
                    System.out.print("Enter element to search: ");
                    int target = keyboard.nextInt();
                    int result = search(numbers, target);
                    if (result != -1) {
                        System.out.println("Found at index: " + result);
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 9:
                    bubleSort(numbers);
                    System.out.print("Array sorted!");
                    printArray(numbers);
                    break; 
                case 10:
                    printStatistics(numbers);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;                               
            
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }while (choise !=0);
            keyboard.close();
        
    }




    public static void printArray(int[] arr){
        System.out.println("[");
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
            if (i<arr.length-1) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

    public static int sum(int[] arr ){
        int total=0;
        for(int i= 0; i<arr.length; i++){
            total+=arr[i];//massiviin element bvriig niilbert hadgalah 
        }
        return total;
    }

    public static double average(int[]arr){
        int total=0;
        for(int i= 0; i<arr.length; i++){
            total+=arr[i];//massiviin element bvriig niilbert hadgalah 
        }
        return total/arr.length;//avg
    }

    public static int max(int[]arr){
        int maxvalue = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i]>maxvalue) {
                maxvalue = arr[i];
            }
        }
        return maxvalue;
    }

    public static int min(int[]arr){
        int minValue = arr[0];
        for(int i = 1;i<arr.length;i++){
            if (arr[i]<minValue) {
                minValue= arr[i];
            }
        }
        return  minValue;
    }

    public static int search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; 
        }
    }
    return -1; 

    }

    public static int[] addElement(int[] arr, int element){
        int[] newArr = new int[arr.length + 1];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }

        newArr[arr.length]= element;

        return newArr;
    }

    public static int[] removeElement(int[] arr, int index){
        int[] newArr = new int[arr.length - 1];
        for(int i=0,j=0; i<arr.length;i++){
            if (i!=index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    public static void bubleSort(int[] arr){
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
        swapped = false;

 
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
           
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;         
        }
    }

    public static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("         ARRAY PROCESSOR v1.0");
        System.out.println("========================================");
        System.out.println("1. View Array");
        System.out.println("2. Add Element");
        System.out.println("3. Remove Element");
        System.out.println("4. Calculate Sum");
        System.out.println("5. Calculate Average");
        System.out.println("6. Find Maximum");
        System.out.println("7. Find Minimum");
        System.out.println("8. Search Element");
        System.out.println("9. Sort Array");
        System.out.println("10. Statistics (All)");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter choice: ");
    }

    public static void printStatistics(int[] arr) {
        System.out.println("\n========== STATISTICS ==========");
        System.out.print("Array: ");
        printArray(arr);
        System.out.println("Length: " + arr.length);
        System.out.println("Sum: " + sum(arr));
        System.out.printf("Average: %.2f%n", average(arr));
        System.out.println("Maximum: " + max(arr));
        System.out.println("Minimum: " + min(arr));
        System.out.println("================================");
    }
}
