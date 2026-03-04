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