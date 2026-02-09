public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPages(){
        return pages;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPages(int pages){
        this.pages=pages;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public double getReadingTime() {
        return (double) pages / 30;
    }

    public void applyDiscount(double percent){
        price = price - (price * percent / 100);
    }

    public void displayinfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
    }
}


