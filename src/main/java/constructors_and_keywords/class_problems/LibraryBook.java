package constructors_and_keywords.class_problems;

public class LibraryBook {
    public String title;
    public String isbn;
    public boolean catalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = (isbn == null || isbn.trim().isEmpty()) ? "PENDING" : isbn;
        this.catalogued = true;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public void printStatus() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
    }

    public String getStatusString() {
        return title + " | " + isbn + " | Catalogued: " + catalogued;
    }
}