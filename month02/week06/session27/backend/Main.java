public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("e001", "huslen", "it", 10000000);
        emp1.displayInfo();

        Employee emp2 = new Employee("e002", "saruul", "hr");
        emp2.displayInfo();

        emp2.raiseSalary(20);
        emp2.setDepartment("finance");
        emp2.displayInfo();
    }
}
