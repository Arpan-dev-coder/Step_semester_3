package constructors_and_keywords.assigment_problems;

public class ParkingTicket {
    public String vehicleNo;
    public double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    public final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    public final void printReceipt(int overstayMinutes) {
        if (overstayMinutes <= 0) {
            System.out.println(vehicleNo + " - No fine, within allotted time");
        } else {
            System.out.println(vehicleNo + " - Fine: Rs " + calculateFine(overstayMinutes));
        }
    }

    public String getReceiptString(int overstayMinutes) {
        if (overstayMinutes <= 0) {
            return vehicleNo + " - No fine, within allotted time";
        } else {
            return vehicleNo + " - Fine: Rs " + calculateFine(overstayMinutes);
        }
    }
}