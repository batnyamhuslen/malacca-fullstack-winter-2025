public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("rookie");
        Cat cat = new Cat("miki");
        Bird bird = new Bird("jony");
        Fish fish = new Fish("joy");

        Animal[] animals = { dog, cat, bird, fish };

        for (Animal animal : animals) {
            animal.introduce();
            System.out.println(animal.makeSound());
            System.out.println(animal.move());
        }
    }
}
