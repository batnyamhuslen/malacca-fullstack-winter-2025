package month02.week07.session35.backend.task;
public class Tsagiinajiltan extends Employee {
    private double bonustime;

    public Tsagiinajiltan(String name, double baseSalary, double bonustime){
        super(name, baseSalary);
        this.bonustime=bonustime;
    }
    @Override
    public double getSalary() {
        return baseSalary + bonustime ;
    }
}
