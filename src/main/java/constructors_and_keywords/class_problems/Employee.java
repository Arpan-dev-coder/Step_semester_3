package constructors_and_keywords.class_problems;

public class Employee {
    public String empId;
    public double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printStatus() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }

    public String getStatusString() {
        return empId + " | Final Salary: Rs " + salary;
    }
}