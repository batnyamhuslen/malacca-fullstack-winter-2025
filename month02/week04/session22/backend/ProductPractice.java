public class ProductPractice {
    public static void main(String[] args) {
        Product laptop = new Product();
        laptop.name = "macbook";
        laptop.price = 2500000;
        laptop.quantity = 1;

        Product mouse = new Product();
        mouse.name ="superlight2";
        mouse.price = 450000;
        mouse.quantity = 3;

        Product pad = new Product();
        pad.name = "ipad";
        pad.price = 2000000;
        pad.quantity = 1;

        double grandtotal = 0;
      
        System.out.println("product1" );   
        laptop.displayInfo();
        grandtotal+=laptop.calculateTotal();
        
        System.out.println("product2" );   
        mouse.displayInfo();
        grandtotal+=mouse.calculateTotal();

        System.out.println("product3" );   
        pad.displayInfo();
        grandtotal+=pad.calculateTotal();

        System.out.println("----------------------------------");
        System.out.println("GRAND TOTAL:" + (int)grandtotal+"₮" );

    }
}
