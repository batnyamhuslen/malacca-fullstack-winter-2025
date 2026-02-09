public class Cat {
    String catName;
    int age;
    String gender;
    double weight;
    String color;

    void info(){
        System.out.println("catname"+ catName);
        System.out.println("age"+ age);
        System.out.println("gender"+ gender);
        System.out.println("weight"+weight);
        System.out.println("color"+color);
    }

    void gettingOld(){
        age=age+1;
    }
    
    int getAgeacat() {
        return age;
    }
}
