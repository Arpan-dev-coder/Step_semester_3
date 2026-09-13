package classes_and_objects.assigment_problems;

public class Employee {
    public String empId;
    public String empName;
    public double salary;
    public boolean isIntern;

    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
        employeeCount++;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}