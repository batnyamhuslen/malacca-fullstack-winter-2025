
/**
 * ДААЛГАВАР:
 * Product class үүсгэж, бүтээгдэхүүний хөнгөлөлттэй үнэ тооцоолох програм бич.
 *
 * ШААРДЛАГА:
 * 1. Product class-д дараах fields нэмэх:
 * - name (String) - Нэр
 * - price (double) - Үнэ
 * - quantity (int) - Тоо ширхэг
 *
 * 2. Дараах методууд нэмэх:
 * - getTotalPrice() - нийт үнэ (price * quantity)
 * - applyDiscount(double percentage) - хөнгөлөлт хийх
 * - displayProduct() - мэдээлэл хэвлэх
 *
 * 3. 2 Product үүсгэж, хөнгөлөлт хийж, мэдээлэл харуулах
 *
 * ЖИШЭЭ ГАРАЛТ:
 * === Бүтээгдэхүүн 1 ===
 * Нэр: Laptop
 * Үнэ: 3000000.0₮
 * Тоо ширхэг: 2
 * Нийт үнэ: 6000000.0₮
 * 15.0% хөнгөлөлт хийгдлээ
 * Хөнгөлөлттэй үнэ: 5100000.0₮
 */

class Product {
    // Fields энд бичнэ үү
    String name;
    double price;
    int quantity;

   
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price*quantity;
    }
    public void applyDiscount(double percentage){
        price= price-(price*percentage/100);
        System.out.println("хөнгөлөлт "+price);
    }
   
    public void displayProduct(){
        System.out.println("ЖИШЭЭ ГАРАЛТ:");
        System.out.println("une "+price);
        System.out.println("ner "+name);
        System.out.println("shirheg "+quantity);
        System.out.println("niit une"+ getTotalPrice());
        System.out.println();
    }
}

public class Khuslen {
    public static void main(String[] args) {
        // Product үүсгэж, хөнгөлөлт хийх
        Product baraaAlim = new Product();
        baraaAlim.name = "alim";
        baraaAlim.price = 5000;
        baraaAlim.quantity= 10;
        
        baraaAlim.displayProduct();
        baraaAlim.applyDiscount(15);
        System.out.println("hymdraltai " + baraaAlim.getTotalPrice());
    }
}


