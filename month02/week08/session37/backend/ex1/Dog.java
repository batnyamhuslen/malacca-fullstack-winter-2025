public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
    @Override
    public String makeSound() {
        return "Woof!";
    }
    @Override
    public String move() {
        return "running";
    }
    
}
