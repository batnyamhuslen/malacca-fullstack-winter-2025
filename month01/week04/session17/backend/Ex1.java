public class Ex1 {
    public static void main(String[] args) {
        String[] fruits = {"Алим", "Жүрж", "Гүзээлзгэнэ", "Чавга", "Үзэм"};
        System.out.println("Эхний жимс:"+fruits[0]);
        System.out.println("Сүүлийн жимс"+fruits[fruits.length-1]);
        System.out.println("Нийт жимс:"+ fruits.length);
        fruits[2]= "Тарвас";
        System.out.println("Шинэ гурав дахь:");
        System.out.println("=== Бүх жимс ===");
        for(int i = 0; i<fruits.length; i++){
            System.out.println( (i + 1) + ". " +fruits[i]);
        }
        
        System.out.println("=== For-each ===");
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }
}
