package inheritance.assigment_problems;

import java.util.Arrays;

public class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;

    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    private int feesPaid = 0;
    private String lastPaymentMode = null;

    private static int memberCounter = 2000;
    private static int membersEnrolled = 0;
    public final String membershipNumber;

    // Constructor for Problem 1
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("memberId must not be blank, whitespace-only, or shorter than 4 characters");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        memberCounter++;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + memberCounter;
    }

    // Constructor for Problem 5
    public GymMember(int monthlyFee) {
        this.memberId = "AUTOGEN";
        this.monthlyFee = monthlyFee;
        memberCounter++;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + memberCounter;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getMonthlyFee() {
        return this.monthlyFee;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Direct child (single inheritance)";
        }
        return "Base class (GymMember)";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember m : members) {
                if (m != null) {
                    total += m.getSessionsAttended();
                }
            }
        }
        return total;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < 10) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int sum = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            sum += lateFeeHistory[i];
        }
        return sum;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (GymMember member : members) {
                if (member == null) continue;
                String info = member.displayInfo().replace(" Member", "");
                sb.append(info);
                if (member instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) member;
                    sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public void payFee(int amount) {
        this.feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        this.lastPaymentMode = mode;
        payFee(amount);
    }

    public int getFeesPaid() {
        return this.feesPaid;
    }

    public String getLastPaymentMode() {
        return this.lastPaymentMode;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'G') {
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
        memberCounter = 2000;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members != null) {
            for (GymMember m : members) {
                if (m == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (m instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " +
               groupCount + " group | " + individualCount + " individual";
    }
}