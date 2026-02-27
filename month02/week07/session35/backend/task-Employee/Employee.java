package month02.week07.session35.backend.task;
public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary){
        this.name=name;
        this.baseSalary=baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public String getName() {
        return name;
    }

    public double getSalary(){
        return baseSalary;
    }
    public String getinfo(){
        return " Name:" + name + "Salary:" + getSalary();
    }
}