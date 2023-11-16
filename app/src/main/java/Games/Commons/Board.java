package Games.Commons;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {
    private final Map<Square, Piece> board;
    private final int rows;
    private final int columns;

    public Board(Map<Square, Piece> board, int rows, int columns) {
        this.board = board;
        this.rows = rows;
        this.columns = columns;
    }

    public Map<Square, Piece> getBoard() {
        return board;
    }

    public Result<Board, Boolean> move(Square start, Square end) {
        Piece piece = getPieceAt(start);
        if (piece == null) {
            return new Result<>(Optional.empty(), true);
        }
        if (piece.getMovements().isValid(this, start, end)) {
            Map<Square, Piece> newBoard = new HashMap<>(board);
            newBoard.remove(start);
            newBoard.put(end, piece);
            return new Result<>(Optional.of(new Board(newBoard, rows, columns)), false);
        }
        return new Result<>(Optional.empty(), true);
    }

    public Piece getPieceAt(Square square) {
        return board.get(square);
    }

    public boolean getIfSquareHasPieceByRowAndColumn(int targetRow, int targetColumn) {
        return board.get(getSquareByRowAndColumn(targetRow, targetColumn)) != null;
    }

    public Square getSquareByRowAndColumn(int targetRow, int targetColumn) {
        for (Map.Entry<Square, Piece> entry : board.entrySet()) {
            Square square = entry.getKey();
            if (square.getRow() == targetRow && square.getColumn() == targetColumn) {
                return square;
            }
        }
        return null;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
