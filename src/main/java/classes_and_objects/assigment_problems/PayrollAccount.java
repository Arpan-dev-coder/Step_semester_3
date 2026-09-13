package classes_and_objects.assigment_problems;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Initial basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit rejected: amount must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduction rejected: percent must be between 0 and 100");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}