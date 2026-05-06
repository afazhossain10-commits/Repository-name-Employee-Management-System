import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private String position;
    private double salary;
    private String joinDate;

    public Employee(int id, String name, String department,
                    String position, double salary, String joinDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getJoinDate() { return joinDate; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String d) { this.department = d; }
    public void setPosition(String p) { this.position = p; }
    public void setSalary(double s) { this.salary = s; }

    public String toString() {
        return id + " | " + name + " | " + department + " | " +
               position + " | " + salary + " | " + joinDate;
    }
}
