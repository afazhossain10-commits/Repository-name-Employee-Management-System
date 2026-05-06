import java.util.*;
import java.io.*;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static HashMap<Integer, Employee> empMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeFileHandler.loadFromFile(employees, empMap);

        while (true) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Generate Report");
            System.out.println("7. Save & Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(); break;
                case 4: deleteEmployee(); break;
                case 5: searchEmployee(); break;
                case 6: EmployeeReportGenerator.generateReport(employees); break;
                case 7:
                    EmployeeFileHandler.saveToFile(employees);
                    System.out.println("Saved. Exiting...");
                    System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();

        System.out.print("Position: ");
        String pos = sc.nextLine();

        System.out.print("Salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        System.out.print("Join Date: ");
        String date = sc.nextLine();

        Employee e = new Employee(id, name, dept, pos, sal, date);
        employees.add(e);
        empMap.put(id, e);

        System.out.println("Employee added!");
    }

    static void viewEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    static void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (empMap.containsKey(id)) {
            Employee e = empMap.get(id);

            System.out.print("New Name: ");
            e.setName(sc.nextLine());

            System.out.print("New Salary: ");
            e.setSalary(sc.nextDouble());

            System.out.println("Updated!");
        } else {
            System.out.println("Not found");
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = empMap.remove(id);
        if (e != null) {
            employees.remove(e);
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found");
        }
    }

    static void searchEmployee() {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                System.out.println(e);
            }
        }
    }
}
