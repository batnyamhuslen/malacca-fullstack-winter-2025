public class Dog {
    private String dogName;
    private String dogRace;
    private boolean isMale;

    public Dog(String n, String r, boolean male){
        this.dogName = n;
        this.dogRace = r;
        this.isMale = male;
    }

    public String getDogName(){
           return dogName;
    }
    public String getDogRace(){
           return dogRace;
    }
    public boolean getisMale(){
           return isMale;
    }
    
    
}
