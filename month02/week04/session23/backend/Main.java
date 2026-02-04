public class Main {
    public static void main(String[] args) {
        Cat chlovy = new Cat();
        chlovy.catName = "Chloe";
        chlovy.age = 3;
        chlovy.gender = "male";
        chlovy.color = "yellow";
        chlovy.weight =3;
        //System.out.println(chlovy.getAgeacat());

        Animal Lion = new Animal();
        Lion.name = "Sinba";
        Lion.age = 10;
        Lion.color = "yellow";

        Animal dog = new Animal();
        dog.name = "ruki";
        dog.age = 4;
        dog.color = "black";

        Human ochiroo = new Human();
        System.out.println(ochiroo.getAge());
        System.out.println(ochiroo.getName());

        Human hangai = new Human();
        System.out.println(hangai.getAge());
        System.out.println(hangai.getName());
        

        System.out.println(Lion.getAgeAnimal());
        System.out.println(Lion.getColor());
        System.out.println(Lion.getname());

        System.out.println(dog.getAgeAnimal());
        System.out.println(dog.getColor());
        System.out.println(dog.getColor());

    }

}
