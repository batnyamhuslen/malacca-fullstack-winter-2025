package month02.week07.session32.backend.ex1;
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee(3000);
        Manager mgr = new Manager(6000);

        System.out.println("Employee bonus" + emp.calculateBonus());
        System.out.println("manager bonus" + mgr.calculateBonus());
    }
}
