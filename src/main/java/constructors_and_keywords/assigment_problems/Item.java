package constructors_and_keywords.assigment_problems;

public class Item {
    public String itemName;
    public int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock += stock;
    }

    public void printStatus() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }

    public String getStatusString() {
        return itemName + " | Final Stock: " + stock;
    }
}