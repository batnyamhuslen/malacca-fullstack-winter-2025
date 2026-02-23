public class Main {
    public static void main(String[] args) {
        System.out.println("session31");

    //1
        Bird tagtaa = new Bird("male", "pigeon");
        tagtaa.sayHello();
        Dog bulldog = new Dog("roux", 3);
        bulldog.sayHello();
        Cat egyptianCat = new Cat("sysy", "red");
        egyptianCat.sayHello();

    //2
        Porsche porsche911 = new Porsche("yellow", "porsche");
        porsche911.printinfo();

        Tesla modelS = new Tesla("black", "tesla");
        modelS.printinfo();

    //3
        Circle circle1 = new Circle(14, "yellow");
        circle1.printInfo();

        Triangle triangle1 = new Triangle(15, 15, "red");
        triangle1.printInfo();
        
    }
}
