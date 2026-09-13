package constructors_and_keywords.class_problems;

public class FeeAccount {
    public String regNo;
    public double totalFee;

    public FeeAccount() {
    }

    public FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public final double calculateLateFee(int daysLate) {
        return daysLate * (totalFee * 0.01);
    }

    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate));
        }
    }

    public String getSummaryString(int daysLate) {
        if (daysLate <= 0) {
            return regNo + " - On time, no late fee";
        } else {
            return regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate);
        }
    }

    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}