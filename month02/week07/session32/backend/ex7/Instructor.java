public class Instructor extends Person {
    private String subject;

    public Instructor(String name, String subject) {
        super(name);
        this.subject = subject;
    }
    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        return "Instructor: " + name + " subject=" + subject;
    }
}
