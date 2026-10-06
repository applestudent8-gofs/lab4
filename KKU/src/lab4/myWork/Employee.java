package lab4.myWork;

public class Employee extends Person {
    private int employeeId;
    private String role;
    private double basicSalary;
    private double bonus;

    public Employee(String name, int age, int employeeId, String role, double basicSalary, double bonus) {
        super(name, age);
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public int getEmployeeId() { return employeeId; }
    public String getRole() { return role; }
    public double getBasicSalary() { return basicSalary; }
    public double getBonus() { return bonus; }

    public void setBonus(double bonus) { this.bonus = bonus; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double calculateTotalSalary() {
        return basicSalary + bonus;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Age: " + age + 
                           ", Role: " + role + ", Total Salary: " + calculateTotalSalary());
    }
}
