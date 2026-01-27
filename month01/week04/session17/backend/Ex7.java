public class Ex7 {
    public static void main(String[] args) {
        int [] ages = {15, 22, 18, 30, 12, 25, 45, 17, 19};
        int threshold = 18;
        System.out.println(threshold + "ба түүнээс насанд хүрэгчид:");
        int count =0;
        for (int age:ages){
            if (age<threshold) {
                System.out.println("Нас:" + age );
                count++;

            }
        }
        System.out.println("Нийт:" +count + "хүн");
    }
}
