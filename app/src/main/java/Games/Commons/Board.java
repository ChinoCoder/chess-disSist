package Games.Commons;

import Games.Chess.Type;

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
        Piece piece = board.get(start);
        if (piece == null) {
            return new Result<>(Optional.empty(), true);
        }
        else {
            if (piece.getMovements().isValid(this, start, end)) {
                Map<Square, Piece> newBoard = board;
                newBoard.put(start, null);
                newBoard.put(end, piece);
                return new Result<>(Optional.of(new Board(newBoard, rows, columns)), false);
            }
        }
        return new Result<>(Optional.empty(), true);
    }

    public boolean getIfSquareHasPieceByRowAndColumn(int targetRow, int targetColumn) {
        for (Map.Entry<Square, Piece> entry : board.entrySet()) {
            Square square = entry.getKey();
            if (square.getRow() == targetRow && square.getColumn() == targetColumn) {
                if (entry.getValue() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPieceChecked(Square target){
        for (Map.Entry<Square, Piece> entry : board.entrySet()) {
            Square square = entry.getKey();
            if (!move(square, target).getError()) {
                return true;
            }
        }
        return false;
    }

    public boolean isKingChecked(Color color){
        Square kingSquare = getKing(color);
        return isPieceChecked(kingSquare);
    }

    private Square getKing(Color color){
        for (Map.Entry<Square, Piece> entry : board.entrySet()) {
            Square square = entry.getKey();
            if (entry.getValue() != null && entry.getValue().getColor() == color && entry.getValue().getType() == Type.KING) {
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
