package lab4.myWork;

public class Employee {
    private String name;
    private int employeeId;
    private String role;
    private double basicSalary;
    private double bonus;

    public Employee(String name, int employeeId, String role) {
        this.name = name;
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = 5000.0;
        this.bonus = 0.0;
    }

    public Employee(String name, int employeeId, String role, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = basicSalary;
        this.bonus = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
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

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Role: " + role + 
                           ", Total Salary: " + calculateTotalSalary());
    }

    public boolean equals(Employee emp) {
        if (emp == null) return false;
        return this.employeeId == emp.employeeId;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Role=" + role + 
               ", Total Salary=" + calculateTotalSalary() + "]";
    }
}
