import java.io.*;
import java.util.*;

public class EmployeeFileHandler {

    static final String FILE = "data/employees.txt";

    public static void saveToFile(ArrayList<Employee> list) {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            for (Employee e : list) {
                pw.println(e.getId() + "," + e.getName() + "," +
                        e.getDepartment() + "," + e.getPosition() + "," +
                        e.getSalary() + "," + e.getJoinDate());
            }
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public static void loadFromFile(ArrayList<Employee> list,
                                    HashMap<Integer, Employee> map) {
        try (Scanner sc = new Scanner(new File(FILE))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                Employee e = new Employee(
                        Integer.parseInt(data[0]),
                        data[1], data[2], data[3],
                        Double.parseDouble(data[4]),
                        data[5]
                );
                list.add(e);
                map.put(e.getId(), e);
            }
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}
