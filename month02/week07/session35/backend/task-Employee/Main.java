package month02.week07.session35.backend.task;
public class Main {
    public static void main(String[] args) {
        
        Employee employee = new Employee("Ochiroo", 3000000);
        Manager manager = new Manager("Khuslen", 5000000, 550000);
        Tsagiinajiltan ajiltan = new Tsagiinajiltan("bataa", 1500000, 100000);

      
        System.out.println(employee.getinfo());
        System.out.println(manager.getinfo());
        System.out.println(ajiltan.getinfo());
    }
}
