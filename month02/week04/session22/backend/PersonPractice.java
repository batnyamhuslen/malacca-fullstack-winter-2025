public class PersonPractice {
    public static void main(String[] args) {
        
        Person hun1 = new Person();
        hun1.name = "Khuslen";
        hun1.age = 24;
        hun1.city = "Ulaanbatar";

        Person hun2 = new Person();
        hun2.name = "Bataa";
        hun2.age = 30;
        hun2.city = "Darkhan";

        Person hun3 = new Person();
        hun3.name = "Sukhee";
        hun3.age = 40;
        hun3.city = "Erdenet";

        hun1.info();
        System.out.println("--------------");
        hun2.info();
        System.out.println("--------------");
        hun3.info();
    }
}
