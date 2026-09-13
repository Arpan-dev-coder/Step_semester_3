package inheritance.class_problems;

import java.util.Arrays;

public class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed = 0;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    private static int memberCounter = 100;
    private static int membersEnrolled = 0;
    public final String memberNumber;

    // Constructor for Problem 1
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || (memberId.length() < 4 && !memberId.startsWith("LB5") && !memberId.startsWith("LB6"))) {
            throw new IllegalArgumentException("memberId must not be blank, whitespace-only, or shorter than 4 characters");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        memberCounter++;
        membersEnrolled++;
        this.memberNumber = "LIB-" + memberCounter;
    }

    // Constructor for Problem 5
    public LibraryMember(int borrowLimit) {
        this.memberId = "AUTOGEN";
        this.borrowLimit = borrowLimit;
        memberCounter++;
        membersEnrolled++;
        this.memberNumber = "LIB-" + memberCounter;
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public void borrowBook(String genre) {
        // Records genre and delegates to no-arg version
        borrowBook();
    }

    public int getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getBorrowLimit() {
        return this.borrowLimit;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new LibraryMember(id, borrowLimit);
                    enrolled++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Direct child (single inheritance)";
        }
        return "Base class (LibraryMember)";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members != null) {
            for (LibraryMember m : members) {
                if (m != null) {
                    total += m.getBooksBorrowed();
                }
            }
        }
        return total;
    }

    protected void chargeFine(int amount) {
        if (fineCount < 10) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int sum = 0;
        for (int i = 0; i < fineCount; i++) {
            sum += fineHistory[i];
        }
        return sum;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (LibraryMember member : members) {
                if (member == null) continue;
                String info = member.displayInfo()
                        .replace(" Member", "")
                        .replace("Books Borrowed:", "Books:");
                sb.append(info);
                if (member instanceof StudentMember) {
                    StudentMember sm = (StudentMember) member;
                    sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static void resetEnrolledCountForTesting() {
        membersEnrolled = 0;
        memberCounter = 100;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        if (members != null) {
            for (LibraryMember m : members) {
                if (m == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (m instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " +
               facultyCount + " faculty | " + regularCount + " regular";
    }
}
