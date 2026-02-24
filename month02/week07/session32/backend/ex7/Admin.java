public class Admin extends Person {
    private String department;

    public Admin(String name, String department) {
        super(name);
        this.department = department;
    }
    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        return "Admin: " + name + " department=" + department;
    }

}
