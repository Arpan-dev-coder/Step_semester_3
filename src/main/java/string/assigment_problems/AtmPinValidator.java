package string.assigment_problems;

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        System.out.println(getPinLengthStatus(pin));
    }

    public static String getPinLengthStatus(String pin) {
        if (pin != null && pin.length() == 4) {
            return "PIN length OK.";
        } else {
            return "Invalid PIN — must be exactly 4 digits.";
        }
    }
}