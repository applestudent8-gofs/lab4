package lab4.myWork;

public class Student extends Employee {

    public Student(String name, int age, int employeeId, String role) {
        super(name, age, employeeId, role, 0.0, 0.0);
    }

    @Override
    public String toString() {
        return "Student Trainee [ID=" + getEmployeeId() + ", Name=" + getName() + 
               ", Age=" + getAge() + ", Role=" + getRole() + ", Unpaid]";
    }

    @Override
    public void displayDetails() {
        System.out.println(toString());
    }
}
