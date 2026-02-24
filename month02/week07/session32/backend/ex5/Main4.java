class Animal {
    public String speak() {  
        return "Animal sound";
    }
}


class Dog extends Animal {
    @Override
    public String speak() {  
        return "Woof";
    }
}


public class Main4 {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a.speak());
    }
}
