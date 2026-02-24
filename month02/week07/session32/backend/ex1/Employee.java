public class Employee {
    private double salary;

    public Employee(double salary){
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    public double calculateBonus(){
        return salary*0.10;
    }
}
