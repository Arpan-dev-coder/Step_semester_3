package constructors_and_keywords.class_problems;

public class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount() {
        super();
    }

    public HostelFeeAccount(String regNo, double totalFee) {
        super(regNo, totalFee);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.pay(amount);
        } else {
            account.pay(amount);
        }
    }

    public static String processBatch(FeeAccount[] accounts, double amount) {
        int hostelCount = 0;
        int dayScholarCount = 0;
        if (accounts != null) {
            for (FeeAccount acc : accounts) {
                if (acc instanceof HostelFeeAccount) {
                    hostelCount++;
                    acc.pay(amount);
                } else if (acc != null) {
                    dayScholarCount++;
                    acc.pay(amount);
                }
            }
        }
        String summary = "Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount;
        System.out.println(summary);
        return summary;
    }
}