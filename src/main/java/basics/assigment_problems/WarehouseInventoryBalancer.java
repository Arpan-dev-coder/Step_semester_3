package basics.assigment_problems;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        System.out.println(getInventoryAnalysis(sectionA, sectionB));
    }

    public static String getInventoryAnalysis(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) return "";

        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        return String.format("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)",
                totalA, totalB, status, maxQty, maxSection, maxIndex);
    }
}