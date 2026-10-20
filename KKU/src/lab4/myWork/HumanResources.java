package lab4.myWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HumanResources {
    private List<Employee> employees = new ArrayList<>();

    static void logAction(String action) {
        System.out.println("[LOG]: " + action);
    }

    protected boolean isEmployeeExists(int employeeId) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        if (isEmployeeExists(employee.getEmployeeId())) {
            logAction("ID " + employee.getEmployeeId() + " already exists!");
            return false;
        }
        employees.add(employee);
        logAction("Added successfully.");
        return true;
    }

    public boolean removeEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                employees.remove(e);
                logAction("Employee removed successfully.");
                return true;
            }
        }
        logAction("ID not found.");
        return false;
    }

    public boolean updateBonus(int employeeId, double bonus) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                if (e instanceof Student) {
                    logAction("Cannot update bonus for Student trainees!");
                    return false;
                }
                e.setBonus(bonus);
                logAction("Bonus updated.");
                return true;
            }
        }
        logAction("ID not found.");
        return false;
    }

    public void displayAllEmployees() {
        logAction("Displaying all records:");
        if (employees.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        Map<String, Integer> roleCounts = new HashMap<>();

        for (Employee e : employees) {
            e.displayDetails();
            String role = e.getRole();
            roleCounts.put(role, roleCounts.getOrDefault(role, 0) + 1);
        }

        System.out.println("\n--- Role Counts ---");
        for (Map.Entry<String, Integer> entry : roleCounts.entrySet()) {
            System.out.println("Role: " + entry.getKey() + " | Count: " + entry.getValue());
        }
    }
}
