class Student extends Person {
    private int grade;

    public Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    public String getInfo() {
        return "Student: " + name + " grade=" + grade;
    }
}
