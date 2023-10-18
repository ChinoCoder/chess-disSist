package implementedChess;

import mainStuff.Piece;
import mainStuff.Position;

public class Square implements Position {
    private final Piece piece;
    private final int row;
    private final int column;

    public Square(Piece piece, int row, int column) {
        this.piece = piece;
        this.row = row;
        this.column = column;
    }
    public Square(int row, int column) {
        this.piece = null;
        this.row = row;
        this.column = column;
    }
    @Override
    public Piece getPiece() {
        return this.piece;
    }
    @Override
    public Position setPiece(Piece piece) {
        return new Square(piece, this.row, this.column);
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
