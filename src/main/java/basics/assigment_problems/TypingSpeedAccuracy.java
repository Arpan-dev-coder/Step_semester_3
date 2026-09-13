package basics.assigment_problems;

public class TypingSpeedAccuracy {

    public static void checkTypingAccuracy(String original, String typed) {
        System.out.println(getAccuracyReport(original, typed));
    }

    public static String getAccuracyReport(String original, String typed) {
        if (original == null || typed == null) return "";
        int len = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < len; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        int total = original.length();
        double accuracy = total > 0 ? (matched * 100.0 / total) : 0.0;

        if (firstMismatchPos != -1) {
            return String.format("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')",
                    matched, total, accuracy, firstMismatchPos, origChar, typedChar);
        } else if (original.length() != typed.length()) {
            return String.format("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d",
                    matched, total, accuracy, len + 1);
        } else {
            return String.format("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches",
                    matched, total, accuracy);
        }
    }
}