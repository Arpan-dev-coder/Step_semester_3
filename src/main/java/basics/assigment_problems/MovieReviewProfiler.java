package basics.assigment_problems;

public class MovieReviewProfiler {

    public static void classifyWordLengths(String review) {
        System.out.println(getWordLengthClassification(review));
    }

    public static String getWordLengthClassification(String review) {
        if (review == null || review.trim().isEmpty()) {
            return "Short: 0 | Medium: 0 | Long: 0";
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int medCount = 0;
        int longCount = 0;

        for (String w : words) {
            // Strip any punctuation attached to word ends
            String clean = w.replaceAll("[^a-zA-Z]", "");
            int len = clean.isEmpty() ? w.length() : clean.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                medCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        return String.format("Short: %d | Medium: %d | Long: %d", shortCount, medCount, longCount);
    }
}