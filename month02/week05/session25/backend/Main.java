public class Main {
    public static void main(String[] args) {

        Person tuguldur = new Person("tuguldur", "bathuyag", 23);
        System.out.println(tuguldur.getFirstname());

        Dog bankhar = new Dog("bankhar", "mongolian bankhar", true);
        System.out.println(bankhar.getDogName());
        System.out.println(bankhar.getDogRace());
        System.out.println(bankhar.getisMale());
        
    }
}
