package mn.icode;

public class Friendlybehaviour implements Behaviour{
    @Override
    public void act(String message) {
     System.out.println("happy"+message);
        
    }
}
