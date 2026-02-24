class Parent {
    protected void show() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    @Override
    protected void show() {   
        System.out.println("Child method");
    }
}

public class Main6 {
    public static void main(String[] args) {
        Child a = new Child();
        a.show();
    }
}