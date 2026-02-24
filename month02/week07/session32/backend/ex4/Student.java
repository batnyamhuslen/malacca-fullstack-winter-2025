class Student extends Person {
    int grade;

    Student(String name, int grade) {
        super(name);
        this.grade = grade;
        System.out.println("Student created: grade=" + grade);
    }
}