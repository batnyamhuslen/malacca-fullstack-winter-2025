public abstract class Animal {
    protected String name;

    public Animal(String name){
        this.name=name;
    }

    public abstract String makeSound();
    public abstract String move();

    public void introduce(){
        System.out.println("I am "+ name + "I am" + this.getClass());
    }
}
