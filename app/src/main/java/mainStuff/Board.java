package mainStuff;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Board {
    private final Map<Square, Piece> board;

    public Board(Map<Square, Piece> board) {
        this.board = board;
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
                return new Result<>(Optional.of(new Board(newBoard)), false);
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
}
