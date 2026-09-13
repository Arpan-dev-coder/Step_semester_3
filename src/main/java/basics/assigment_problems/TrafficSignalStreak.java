package basics.assigment_problems;

public class TrafficSignalStreak {

    public static void findLongestStreak(String signalLog) {
        System.out.println(getLongestStreakResult(signalLog));
    }

    public static String getLongestStreakResult(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            return "No signals recorded";
        }

        char longestChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestChar = currentChar;
                }
                currentChar = c;
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestChar = currentChar;
        }

        return "Longest Streak: '" + longestChar + "' repeated " + maxStreak + " times";
    }
}