package basics.assigment_problems;

public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean found = false;
        int duplicatedSeat = -1;

        // Nested loops without Collections
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    found = true;
                    duplicatedSeat = seatNumbers[i];
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            System.out.println("Duplicate Seat Number Found: " + duplicatedSeat);
        } else {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static String getDuplicateSeatsResult(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            return "No Duplicate Seats Found";
        }

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    return "Duplicate Seat Number Found: " + seatNumbers[i];
                }
            }
        }
        return "No Duplicate Seats Found";
    }
}