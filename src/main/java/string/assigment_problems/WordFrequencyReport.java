package string.assigment_problems;

import java.util.*;

public class WordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    public static Map<String, Integer> getFilteredWordFrequencyMap(String feedback) {
        Map<String, Integer> freq = new HashMap<>();
        if (feedback == null || feedback.trim().isEmpty()) {
            return freq;
        }

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        String[] words = cleaned.trim().split("\\s+");

        for (String w : words) {
            if (!w.isEmpty() && !STOP_WORDS.contains(w)) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }
        return freq;
    }

    public static void printFilteredWordFrequency(String feedback) {
        Map<String, Integer> freq = getFilteredWordFrequencyMap(feedback);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}