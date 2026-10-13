package lab4.myWork;

public class Employee extends Person {
    private int employeeId;
    private String role;
    private double basicSalary;
    private double bonus;
    public CurrecncyStrategy currency;

    public Employee(String name, int age, int employeeId, String role, double basicSalary, double bonus) {
        super(name, age);
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.currency = null;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculateTotalSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String toString() {
        double total = calculateTotalSalary();
        String salaryDisplay = total + "";

        if (currency != null) {
            float converted = currency.changeTo((float) total);
            salaryDisplay = converted + " " + currency.getSymbol();
        }

        return "ID=" + employeeId + ", Name=" + name + ", Age=" + age + 
               ", Role=" + role + ", Total Salary=" + salaryDisplay;
    }

    public void displayDetails() {
        System.out.println(toString());
    }
}
