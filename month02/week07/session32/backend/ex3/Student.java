class Student extends Person {
    private int grade;

    public Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    public void introduce() {
        System.out.println("Student: " + getName() + " (Grade " + grade + ")");
    }
}