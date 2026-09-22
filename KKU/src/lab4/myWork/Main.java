package lab4.myWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Enter Employee Info");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Bonus or Salary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee Info:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Role: ");
                    String role = scanner.nextLine();

                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();

                    System.out.print("Bonus: ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine();

                    Employee emp = new Employee(name, id, role, salary);
                    emp.setBonus(bonus);
                    employees.add(emp);

                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.println("\n--- Employee Info ---");
                    if (employees.isEmpty()) {
                        System.out.println("No employees entered yet.");
                    } else {
                        for (Employee e : employees) {
                            e.displayDetails();
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = false;

                    for (Employee e : employees) {
                        if (e.getEmployeeId() == updateId) {
                            System.out.println("1. Update Salary");
                            System.out.println("2. Update Bonus");
                            int updateChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (updateChoice == 1) {
                                System.out.print("New Salary: ");
                                double newSalary = scanner.nextDouble();
                                scanner.nextLine();
                                e.setBasicSalary(newSalary);
                                System.out.println("Salary updated.");
                            } else if (updateChoice == 2) {
                                System.out.print("New Bonus: ");
                                double newBonus = scanner.nextDouble();
                                scanner.nextLine();
                                e.setBonus(newBonus);
                                System.out.println("Bonus updated.");
                            }
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
