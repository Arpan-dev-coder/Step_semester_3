package encapsulation.class_problems;

public class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket() {
        this.seatNumber = "A1";
        this.screenId = "SCR-1";
        this.ticketPrice = 250.0;
        this.movieTitle = "Default Movie";
    }

    public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}