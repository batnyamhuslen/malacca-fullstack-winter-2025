class Manager extends Employee {

    public Manager(double salary) {
        super(salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20;
    }
}