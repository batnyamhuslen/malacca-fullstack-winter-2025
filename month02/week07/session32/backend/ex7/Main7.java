import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Person[] people = {
                new Student("temuulen", 12),
                new Instructor("oyuna", "biology"),
                new Admin("munkh", "registry")
        };
    
        for (Person p : people) {
            System.out.println(p.getInfo());
        }
    }
}
