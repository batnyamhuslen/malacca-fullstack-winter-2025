public class Main {
    public static void main(String[] args) {

        FullTimeEmployee hun1 = new FullTimeEmployee("Bat", 3000000);
        FullTimeEmployee hun2 = new FullTimeEmployee("Sara", 3500000);

        PartTimeEmployee hun3 = new PartTimeEmployee("Tuvshin", 0, 40, 10000);
        PartTimeEmployee hun4 = new PartTimeEmployee("Naraa", 0, 45, 8000);

        Employee[] employees = {hun1, hun2, hun3, hun4};

        for (Employee a : employees) {
            a.printPayslip();
        }
    }
}