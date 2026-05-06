import java.util.*;

public class EmployeeReportGenerator {

    public static void generateReport(ArrayList<Employee> list) {
        double total = 0;

        for (Employee e : list) {
            total += e.getSalary();
        }

        System.out.println("\n=== REPORT ===");
        System.out.println("Total Employees: " + list.size());
        System.out.println("Total Salary: " + total);
        System.out.println("Average Salary: " + (total / list.size()));
    }
}
