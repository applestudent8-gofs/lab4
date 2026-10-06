package lab4.myWork;

public final class HumanResources {
    private Employee emp1 = null;
    private Employee emp2 = null;

    static void logAction(String action) {
        System.out.println("[LOG]: " + action);
    }

    protected boolean isEmployeeExists(int employeeId) {
        if (emp1 != null && emp1.getEmployeeId() == employeeId) return true;
        if (emp2 != null && emp2.getEmployeeId() == employeeId) return true;
        return false;
    }

    public boolean addEmployee(Employee employee) {
        if (isEmployeeExists(employee.getEmployeeId())) {
            logAction("ID " + employee.getEmployeeId() + " already exists!");
            return false;
        }

        if (emp1 == null) {
            emp1 = employee;
            logAction("Added to Slot 1 as: " + (employee instanceof Student ? "Student" : "Employee"));
            return true;
        } else if (emp2 == null) {
            emp2 = employee;
            logAction("Added to Slot 2 as: " + (employee instanceof Student ? "Student" : "Employee"));
            return true;
        } else {
            logAction("System full! Cannot add more.");
            return false;
        }
    }

    public boolean updateBonus(int employeeId, double bonus) {
        Employee target = null;
        if (emp1 != null && emp1.getEmployeeId() == employeeId) target = emp1;
        if (emp2 != null && emp2.getEmployeeId() == employeeId) target = emp2;

        if (target != null) {
            
            if (target instanceof Student) {
                logAction("Cannot update bonus for Student trainees (Unpaid)!");
                return false;
            }
            target.setBonus(bonus);
            logAction("Bonus updated for Employee ID: " + employeeId);
            return true;
        }

        logAction("ID " + employeeId + " not found.");
        return false;
    }

    public void displayAllEmployees() {
        logAction("Displaying all records:");
        boolean empty = true;
        if (emp1 != null) { emp1.displayDetails(); empty = false; }
        if (emp2 != null) { emp2.displayDetails(); empty = false; }

        if (empty) {
            System.out.println("No records found.");
        }
    }
}
