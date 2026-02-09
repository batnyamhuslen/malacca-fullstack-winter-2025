public class ProductPractice {
    public static void main(String[] args) {
        Product[] numbers = new Product[3];

        Product laptop = new Product();
        laptop.name = "macbook";
        laptop.price = 2500000;
        laptop.quantity = 1;
        numbers[0] = laptop;

        Product mouse = new Product();
        mouse.name = "superlight2";
        mouse.price = 450000;
        mouse.quantity = 3;
        numbers[1] = mouse;

        Product pad = new Product();
        pad.name = "ipad";
        pad.price = 2000000;
        pad.quantity = 1;
        numbers[2] = pad;

        double grandtotal = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("===Product " + (i + 1) + "===");
            numbers[i].displayInfo();
            grandtotal = +grandtotal + numbers[i].calculateTotal();
        }
        System.out.println("Grand Total " + grandtotal);

        // grandtotal+=laptop.calculateTotal();
        // grandtotal+=mouse.calculateTotal();
        // grandtotal+=pad.calculateTotal();
        // System.out.println("--------------------------------");
        // System.out.print("GRANDTOTAL");
        // System.out.print(grandtotal+"T");

        // double grandtotal = 0;
        // System.out.println("product1" );
        // laptop.displayInfo();
        // grandtotal+=laptop.calculateTotal();

        // System.out.println("product2" );
        // mouse.displayInfo();
        // grandtotal+=mouse.calculateTotal();

        // System.out.println("product3" );
        // pad.displayInfo();
        // grandtotal+=pad.calculateTotal();

        // System.out.println("----------------------------------");
        // System.out.println("GRAND TOTAL:" + (int)grandtotal+"₮" );

    }
}
