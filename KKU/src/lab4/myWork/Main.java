package lab4.myWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HumanResources hr = new HumanResources();

        while (true) {
            System.out.println("\n--- Lab 6 HR System ---");
            System.out.println("1. Add Person (Employee / Student)");
            System.out.println("2. Display All Records");
            System.out.println("3. Update Bonus");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    
                    // هنا التعديل الجوهري لـ Lab 6
                    System.out.print("Enter Basic Salary (Enter 0 if Student Trainee): ");
                    double salary = scanner.nextDouble();

                    if (salary == 0) {
                        // إنشاء طالب تدريب مجاني (Student)
                        Student std = new Student(name, age, id, role);
                        hr.addEmployee(std);
                    } else {
                        // إنشاء موظف عادي براتب (Employee)
                        System.out.print("Enter Bonus: ");
                        double bonus = scanner.nextDouble();
                        Employee emp = new Employee(name, age, id, role, salary, bonus);
                        hr.addEmployee(emp);
                    }
                    break;

                case 2:
                    hr.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to update bonus: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Bonus: ");
                    double newBonus = scanner.nextDouble();
                    
                    // كلاس HR سيمنع التحديث تلقائياً إذا كان الشخص طالب تدريب
                    hr.updateBonus(updateId, newBonus);
                    break;

                case 4:
                    HumanResources.logAction("Exiting program... Goodbye!");
                    scanner.close();
                    return;

                default:
                    HumanResources.logAction("Invalid choice! Try again.");
            }
        }
    }
}
