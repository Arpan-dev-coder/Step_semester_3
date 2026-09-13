package basics.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("No Non-Repeating Character Found");
            return '\0';
        }

        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1) {
                System.out.println("First Non-Repeating Character: '" + c + "'");
                return c;
            }
        }

        System.out.println("No Non-Repeating Character Found");
        return '\0';
    }
}