public class Product {
    String name;
    double price;
    int quantity;

    double calculateTotal() {
        return price * quantity;
    }
    void displayInfo() {
        System.out.println(name + " - " + (int) price + "₮ x " + quantity + " = " + (int) calculateTotal() + "₮");
    }
}
