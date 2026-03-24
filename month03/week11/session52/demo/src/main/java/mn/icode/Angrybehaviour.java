package mn.icode;

public class Angrybehaviour implements Behaviour{
    @Override
    public void act(String message) {
        System.out.println("angry"+message);
    }
}
