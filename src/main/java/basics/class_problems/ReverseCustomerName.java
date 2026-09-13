package basics.class_problems;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) return null;
        char[] chars = customerName.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        String reversed = sb.toString();
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
        return reversed;
    }
}