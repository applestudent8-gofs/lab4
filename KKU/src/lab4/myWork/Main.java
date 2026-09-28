package lab4.myWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HumanResources hr = new HumanResources();

        while (true) {
            System.out.println("\n--- HR System Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee Bonus");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter Bonus: ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine();

                    Employee emp = new Employee(name, id, role, salary, bonus);
                    hr.addEmployee(emp);
                    break;

                case 2:
                    hr.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Bonus: ");
                    double newBonus = scanner.nextDouble();
                    hr.updateBonus(updateId, newBonus);
                    break;

                case 4:
                    HumanResources.logAction("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    HumanResources.logAction("Invalid option. Try again.");
            }
        }
    }
}
