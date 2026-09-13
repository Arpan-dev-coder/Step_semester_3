package constructors_and_keywords.assigment_problems;

public class MembershipCard {
    public static String libraryName;
    public static String validUntil;
    public String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
        System.out.println("Membership card issued: " + studentName);
    }
}