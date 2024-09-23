package payroll;
import java.util.*;

public class PayrollSystem {
    private Set<Employee> employees;
    private Map<Integer, Double> payroll;

    public PayrollSystem() {
        employees = new HashSet<>();
        payroll = new HashMap<>();
    }

    // Add employee
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    // Remove employee
    public boolean removeEmployee(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }

    // Update salary in payroll map
    public void updateSalary(int id, double salary) {
        payroll.put(id, salary);
    }

    // Calculate total payroll
    public double totalPayroll() {
        double total = 0;
        for (Double salary : payroll.values()) {
            total += salary;
        }
        return total;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    // List all employees
    public Set<Employee> listAllEmployees() {
        return employees;
    }
}
