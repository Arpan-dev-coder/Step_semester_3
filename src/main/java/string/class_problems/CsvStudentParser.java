package string.class_problems;

public class CsvStudentParser {

    public static void parseStudentRecord(String csvLine) {
        System.out.println(getParsedString(csvLine));
    }

    public static String getParsedString(String csvLine) {
        if (csvLine == null) return "Invalid Record";
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            return "Invalid Record";
        }
        return "Name: " + parts[0].trim() + " | Roll No: " + parts[1].trim() + " | Dept: " + parts[2].trim();
    }
}