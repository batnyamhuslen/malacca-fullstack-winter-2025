package mn.icode;

public class Bird {
    public Bird(String race) {
        this.race = race;
    }
}

class Dove extends Bird implements Swimmable, Flyable {

    public Dove(String race) {
        super(race);
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
