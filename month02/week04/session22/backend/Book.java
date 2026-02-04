public class Book {
    String title, author;
    int pages, price;
    boolean isAvailbale;

    void displayinfo(){
        if (isAvailbale) {
            System.out.println(title + " - nuutsud baina");
        } else {
            System.out.println(title + " - nuutsud baihgui");
        }
    }

    void borrow(){
        if (isAvailbale) {
            System.out.println(title+ "nomiig zeellee.");
            isAvailbale = false;
        }else{
            System.out.println(title+ "nootsud alga");
        }
    }

    void returnbook(){
        isAvailbale = true;
        if (isAvailbale) {
            System.out.println(title+ "nomiig butsaala");
        }
    }
}
