package constructors_and_keywords.assigment_problems;

public class Payment {
    public void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            ((CardPayment) payment).payWithProcessingFee(amount);
            return amount * 1.02;
        } else if (payment != null) {
            payment.pay(amount);
            return amount;
        }
        return 0.0;
    }

    public static double processBatch(Payment[] payments, double[] amounts) {
        double totalCollected = 0.0;
        if (payments != null && amounts != null) {
            for (int i = 0; i < payments.length && i < amounts.length; i++) {
                totalCollected += processTransaction(payments[i], amounts[i]);
            }
        }
        System.out.println("Total Collected: Rs " + totalCollected);
        return totalCollected;
    }
}