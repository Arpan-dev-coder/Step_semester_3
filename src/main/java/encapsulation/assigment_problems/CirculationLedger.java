package encapsulation.assigment_problems;

public class CirculationLedger {
    private static final String DEFAULT_BRANCH_CODE;

    static {
        DEFAULT_BRANCH_CODE = "MAIN-BRANCH-01";
    }

    public static String getDefaultBranchCode() {
        return DEFAULT_BRANCH_CODE;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnlyCount = 0;
        int regularCount = 0;

        if (receipts != null) {
            for (LoanReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (r instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnlyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " +
               referenceOnlyCount + " reference-only | " + regularCount + " regular";
    }
}