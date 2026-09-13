package constructors_and_keywords.assigment_problems;

public class CardPayment extends Payment {
    public void payWithProcessingFee(double amount) {
        double charged = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + charged);
    }
}