public class Fish extends Animal{
    public Fish(String name){
        super(name);
    }

    @Override
    public String makeSound() {
        return"...";
    }

    @Override
    public String move() {
        return "Swimming";
    }
}

