public class Ex5 {
    public static void main(String[] args) {
        int[] numbers = {12, 7, 24, 15, 8, 33, 42, 19, 6};

        // 1. Тэгш тоонуудыг хэвлэх
        System.out.print("Тэгш тоонууд: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 2. Сондгой тоонуудыг хэвлэх
        System.out.print("Сондгой тоонууд: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 3. Тэгш, сондгой тоонуудын тоог олох
        int evenCount = 0;
        int oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Тэгш тоо: " + evenCount + " ширхэг");
        System.out.println("Сондгой тоо: " + oddCount + " ширхэг");
    }
}
