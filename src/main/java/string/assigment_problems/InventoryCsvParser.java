package string.assigment_problems;

public class InventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        System.out.println(getInventoryRecordString(csvLine));
    }

    public static String getInventoryRecordString(String csvLine) {
        if (csvLine == null) return "Invalid Record";
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            return "Invalid Record";
        }
        return "Product: " + parts[0].trim() + " | SKU: " + parts[1].trim() + " | Qty: " + parts[2].trim();
    }
}