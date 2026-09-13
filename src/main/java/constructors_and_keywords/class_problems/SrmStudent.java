package constructors_and_keywords.class_problems;

public class SrmStudent {
    public static String collegeName;
    public static String academicYear;
    public String studentName;

    static {
        collegeName = "SRM University";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    public SrmStudent(String studentName) {
        this.studentName = studentName;
        System.out.println("Student record created: " + studentName);
    }
}