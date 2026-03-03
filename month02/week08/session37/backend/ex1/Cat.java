public class Cat  extends Animal{
    public Cat(String name){
        super(name);
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }
    @Override
    public String move() {
        return "Sneaking";
    }
}
