public class Bird extends Animal{
    public Bird (String name){
        super(name);
    }

    @Override
    public String makeSound() {
        return "Tweet!";
    }
    @Override
    public String move() {
        return "Flying";
    }
}
