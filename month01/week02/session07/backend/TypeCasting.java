public class TypeCasting {
    public static void main(String[] args) {
        // Widening Casting (автомат)
        int myInt = 9;
        double myDouble = 100;  // int → double

        System.out.println("int утга: " + myInt);
        System.out.println("double болсон: " + myDouble);

        // Narrowing Casting (гараар)
        double price = 99.99;
        int roundedPrice = (int) price;  // double → int

        System.out.println("\ndouble утга: " + price);
        System.out.println("int болсон: " + roundedPrice);

        // String → int
        String numStr = "123";
        int numFromStr = Integer.parseInt(numStr);

        System.out.println("\nString утга: " + numStr);
        System.out.println("int болсон: " + numFromStr);

        // int → String
        int number = 456;
        String strFromNum = String.valueOf(number);

        System.out.println("\nint утга: " + number);
        System.out.println("String болсон: " + strFromNum);
    }
}
