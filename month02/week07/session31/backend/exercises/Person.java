public class Person{
    private String name;
    private String email;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void printContact(){
        System.out.println(name+"-"+getEmail());
    }
}
