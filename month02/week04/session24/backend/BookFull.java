
public class BookFull {
    public static void main(String[] args) {
        Book nom = new Book();
        nom.setName("math");
        nom.setAuthor("Grigori");
        nom.setPages(25);
        nom.setPrice(25000);
        
        nom.displayinfo();

        System.out.println("reading time" +nom.getReadingTime()+ "days");

        nom.applyDiscount(10);
    }
}