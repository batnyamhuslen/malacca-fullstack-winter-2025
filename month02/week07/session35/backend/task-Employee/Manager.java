package month02.week07.session35.backend.task;
public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double baseSalary, double bonus){
        super(name, baseSalary);
        this.bonus=bonus;
    }
    @Override
    public double getSalary() {
        return baseSalary +bonus;
    }
}
