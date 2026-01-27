public class Ex6 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        // 1. Хэвийн дарааллаар хэвлэх
        System.out.print("Хэвийн: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // 2. Урвуу дарааллаар хэвлэх
        System.out.print("Урвуу: ");
        for (int i = numbers.length - 1; i>=0; i--) {
            System.out.print(numbers[i] + "  ");
        }
        System.out.println();
    }
}
