package mainStuff;

import implementedChess.Square;

import java.util.List;

public class Board {
    private final Position[] positions;
    private final List<Piece> TakenPieces;

    protected Board(Position[] positions, List<Piece> takenPieces) {
        this.positions = positions;
        TakenPieces = takenPieces;
    }

    public Board(int rows, int columns) {
        Position[] positions = new Position[rows * columns];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Square(i / columns, i % columns);
        }
        this.positions = positions;
        TakenPieces = new java.util.ArrayList<>();
    }

    public Position[] getPositions() {
        return positions;
    }
    public List<Piece> getTakenPieces() {
        return TakenPieces;
    }
    public Position getPosition(int row, int column) {
        return positions[row * 8 + column];
    }
    public boolean checkIfPositionExists(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }
}
