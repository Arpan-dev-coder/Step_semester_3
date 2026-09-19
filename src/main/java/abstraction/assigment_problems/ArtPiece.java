package abstraction.assigment_problems;

public abstract class ArtPiece {
    private static int counter = 0;
    protected String title;
    private final String pieceId;

    public ArtPiece(String title) {
        this.title = title;
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public String getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}