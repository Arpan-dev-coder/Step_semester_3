package string.class_problems;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        System.out.println(getCountString(text));
    }

    public static String getCountString(String text) {
        if (text == null) return "Vowels: 0 | Consonants: 0";
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return "Vowels: " + vowels + " | Consonants: " + consonants;
    }
}