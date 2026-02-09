public class BookLibrary {
    public static void main(String[] args) {

        System.out.println("=== Номын сан ===");
        Book uranzohiol = new Book();
        uranzohiol.author = "Alex";
        uranzohiol.isAvailbale = true;
        uranzohiol.pages = 100;
        uranzohiol.price = 25000;
        uranzohiol.title = "Ulaan malgait";

        Book fitness = new Book();
        fitness.author = "Khuslen";
        fitness.isAvailbale = false;
        fitness.pages = 50;
        fitness.price = 100000;
        fitness.title = "gym";

        Book math = new Book();
        math.author = "Dorj";
        math.isAvailbale = true;
        math.pages = 120;
        math.price = 20000;
        math.title = "12 angi";

        uranzohiol.displayinfo();
        fitness.displayinfo();
        math.displayinfo();

        System.out.println();

        uranzohiol.borrow();
        uranzohiol.displayinfo();
        uranzohiol.returnbook();
    }
}
