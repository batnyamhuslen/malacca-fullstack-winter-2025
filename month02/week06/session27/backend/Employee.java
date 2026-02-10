public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double salary;

    public static final double TAX_RATE = 0.10;

    public Employee(String employeeId, String name, String department, double salary) {
        this.employeeID = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String employeeId, String name, String department) {
        this(employeeId, name, department, 500000);
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void raiseSalary(double percent){
        if (percent>=0 && percent <=100) {
            salary+=salary*percent/100;
        }else{
            System.out.println("Цалинг нэмэх хувь 0-100% хооронд байх ёстой!");
        }
    }
    public double getTaxAmount(){
        return salary * TAX_RATE;
    }
    public double getNetSalary(){
        return salary - getTaxAmount();
    }

    public void displayInfo(){
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf("│ ID: %-30s  │\n", employeeID);
        System.out.printf("│ Нэр: %-29s  │\n", name);
        System.out.printf("│ Хэлтэс: %-28s│\n", department);
        System.out.printf("│ Цалин:₮ %-28.0f│\n", salary);
        System.out.printf("│ Татвар (10%%):₮ %-20.0f │\n", getTaxAmount());
        System.out.printf("│ Цэвэр цалин:₮ %-21.0f │\n", getNetSalary());
        System.out.println("└─────────────────────────────────────┘");
    }
}
