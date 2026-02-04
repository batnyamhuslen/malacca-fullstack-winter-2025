public class Student {
    // Fields
    String name;
    int age;
    String studentId;
    double gpa;

    // Methods
    void study() {
        System.out.println(name + " is studying...");
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + studentId);
        System.out.println("GPA: " + gpa);
    }
}
