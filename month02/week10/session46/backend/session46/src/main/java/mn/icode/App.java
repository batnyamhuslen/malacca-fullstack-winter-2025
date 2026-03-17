package mn.icode;

abstract class Vehicle {
    abstract void prinnInfo();
}

class BigVehicle{
    boolean isBig(){
        return false;
    }
}

class Tractor extends Vehicle {
    @Override
    void prinnInfo() {
     System.out.println("im tractor");
    }
}
class Motorrad extends Vehicle {
    @Override
    void prinnInfo() {
     System.out.println("im motorrat");
    }
}

public class App{

    public static void main( String[] args ){
        Tractor tr1 = new Tractor();
        tr1.prinnInfo();
        Motorrad mr = new Motorrad();
        mr.prinnInfo();
    }
}