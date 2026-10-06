package lab4.myWork;

public final class HumanResources {
    // 3 Employee fields (Max capacity = 3) as required without using arrays
    private Employee emp1 = null;
    private Employee emp2 = null;
    private Employee emp3 = null;

    // Logger method
    static void logAction(String action) {
        System.out.println("[LOG]: " + action);
    }

    // Validate if employee exists
    protected boolean isEmployeeExists(int employeeId) {
        if (emp1 != null && emp1.getEmployeeId() == employeeId) return true;
        if (emp2 != null && emp2.getEmployeeId() == employeeId) return true;
        if (emp3 != null && emp3.getEmployeeId() == employeeId) return true;
        return false;
    }

    // Add employee
    public boolean addEmployee(Employee employee) {
        if (isEmployeeExists(employee.getEmployeeId())) {
            logAction("Employee ID " + employee.getEmployeeId() + " already exists!");
            return false;
        }

        if (emp1 == null) {
            emp1 = employee;
            logAction("Employee added successfully to slot 1.");
            return true;
        } else if (emp2 == null) {
            emp2 = employee;
            logAction("Employee added successfully to slot 2.");
            return true;
        } else if (emp3 == null) {
            emp3 = employee;
            logAction("Employee added successfully to slot 3.");
            return true;
        } else {
            logAction("System capacity reached! Cannot add more employees.");
            return false;
        }
    }

    // Update bonus
    public boolean updateBonus(int employeeId, double bonus) {
        if (emp1 != null && emp1.getEmployeeId() == employeeId) {
            emp1.setBonus(bonus);
            logAction("Bonus updated for Employee ID: " + employeeId);
            return true;
        } else if (emp2 != null && emp2.getEmployeeId() == employeeId) {
            emp2.setBonus(bonus);
            logAction("Bonus updated for Employee ID: " + employeeId);
            return true;
        } else if (emp3 != null && emp3.getEmployeeId() == employeeId) {
            emp3.setBonus(bonus);
            logAction("Bonus updated for Employee ID: " + employeeId);
            return true;
        }
        logAction("Employee ID " + employeeId + " not found.");
        return false;
    }

    // Display all employees
    public void displayAllEmployees() {
        logAction("Displaying all employees:");
        boolean empty = true;
        if (emp1 != null) { emp1.displayDetails(); empty = false; }
        if (emp2 != null) { emp2.displayDetails(); empty = false; }
        if (emp3 != null) { emp3.displayDetails(); empty = false; }

        if (empty) {
            System.out.println("No employees found in the system.");
        }
    }
}
