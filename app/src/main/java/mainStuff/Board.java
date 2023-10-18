package mainStuff;

import java.util.Map;
import java.util.Optional;

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
}
