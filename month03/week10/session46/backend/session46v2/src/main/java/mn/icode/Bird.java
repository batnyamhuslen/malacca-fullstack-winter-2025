package mn.icode;

public class Bird {
    String race;
    public Bird(String race) {
        this.race = race;
    }


    public static void main(String[] args) {
        Dove dove = new Dove("Dove");
        System.out.println(dove.canFly());
    }
}

class Dove extends Bird implements Swimmable, Flyable {

    public Dove(String race) {
        super(race);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canSwim() {
        return true;
    }
}

class RubberBird extends Bird implements Swimmable, Flyable {
    public RubberBird(String race) {
        super(race);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canSwim() {
        return false;
    }
}


