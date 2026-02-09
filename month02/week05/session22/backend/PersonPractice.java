public class PersonPractice {
    public static void main(String[] args) {
        Person[] people = new Person[3];

        Person hun1 = new Person();
        hun1.name = "Khuslen";
        hun1.age = 24;
        hun1.city = "Ulaanbatar";
        people[0] = hun1;

        Person hun2 = new Person();
        hun2.name = "Bataa";
        hun2.age = 30;
        hun2.city = "Darkhan";
        people[1] = hun2;

        Person hun3 = new Person();
        hun3.name = "Sukhee";
        hun3.age = 40;
        hun3.city = "Erdenet";
        people[2] = hun3;

        for (int i = 0; i < people.length; i++) {
            System.out.println("===hun " + (i + 1) + "===");
            people[i].info();
        }

        // hun1.info();
        // System.out.println("--------------");
        // hun2.info();
        // System.out.println("--------------");
        // hun3.info();
    }
}
