package classes_and_objects.class_problems;

public class Student {
    public String name;
    public int attendance;
    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName + " Students created: " + studentCount);
    }
}