package payroll;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Add employees
        payrollSystem.addEmployee(new Employee(1, "Alice", 5000));
        payrollSystem.addEmployee(new Employee(2, "Bob", 6000));
        
        // Update payroll
        payrollSystem.updateSalary(1, 5000);
        payrollSystem.updateSalary(2, 6000);
        
        // Display total payroll
        System.out.println("Total Payroll: " + payrollSystem.totalPayroll());
        
        // List all employees
        payrollSystem.listAllEmployees().forEach(System.out::println);
    }
}

