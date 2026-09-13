package basics.class_problems;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] chars = text.toCharArray();
        int n = chars.length;
        char[] reversed = new char[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = chars[n - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    public static String checkAllApproaches(String text) {
        boolean it = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        String itStr = it ? "Palindrome" : "Not Palindrome";
        String recStr = rec ? "Palindrome" : "Not Palindrome";
        String revStr = rev ? "Palindrome" : "Not Palindrome";

        String result = "Iterative: " + itStr + " | Recursive: " + recStr + " | Array Reversal: " + revStr;
        System.out.println(result);
        return result;
    }
}