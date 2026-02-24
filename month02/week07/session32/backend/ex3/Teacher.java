class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        System.out.println("Teacher: " + getName() + " (" + subject + ")");
    }
}