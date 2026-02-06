public class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    public Person(){

    }

    public Person (String f, String l, int a){
        firstName= f;
        lastName = l;
        age = a;
    }
    public String getFirstname(){
        return firstName;
    }

    public String getlastname(){
        return lastName;
    }

    public int getAge(){
        return age;
    }


}
