package encapsulation.class_problems;

public class PremiumMovieTicket extends MovieTicket {
    public PremiumMovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
    }

    public double getTicketPriceViaProtected() {
        // Can access protected ticketPrice from subclass
        return this.ticketPrice;
    }
}