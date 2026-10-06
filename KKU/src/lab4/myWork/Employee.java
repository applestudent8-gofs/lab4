package lab4.myWork;

public class Employee extends Person {
    private String name;
    private int employeeId;
    private String role;
    private double basicSalary;
    private double bonus;

    public Employee(String name, int employeeId, String role, double basicSalary, double bonus) {
        this.name = name;
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
    public String getRole() { return role; }
    public double getBasicSalary() { return basicSalary; }
    public double getBonus() { return bonus; }

    public void setBonus(double bonus) { this.bonus = bonus; }

    public double calculateTotalSalary() {
        return basicSalary + bonus;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Role: " + role + 
                           ", Basic Salary: " + basicSalary + ", Bonus: " + bonus + 
                           ", Total Salary: " + calculateTotalSalary());
    }
}
