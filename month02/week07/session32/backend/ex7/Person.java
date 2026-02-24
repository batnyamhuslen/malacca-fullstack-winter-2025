public class Person {

    protected String name;

    public Person(String name){
        this.name=name;
    }
    public String getInfo(){
        return "person"+name;
    }
}
