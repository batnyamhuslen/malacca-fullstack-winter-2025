public class Person {
    private String name;
    
    public Person(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void introduce(){
        System.out.println("person:" +name);
    }
}
