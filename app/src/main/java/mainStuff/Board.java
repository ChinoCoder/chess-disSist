package mainStuff;

import Exceptions.IllegalMoveException;

import java.util.Map;

public class Board {
    private final Map<Square, Piece> board;

    public Board(Map<Square, Piece> board) {
        this.board = board;
    }

    public Map<Square, Piece> getBoard() {
        return board;
    }

    public Board move(Square start, Square end) throws IllegalMoveException {
        Piece piece = board.get(start);
        if (piece == null) {
            throw new IllegalMoveException("No piece at start square");
        }
        else {
            for (MovementValidator validator : piece.getMovements()) {
                if (validator.validateMove(this, start, end)) {
                    Map<Square, Piece> newBoard = board;
                    newBoard.put(start, null);
                    newBoard.put(end, piece);
                    return new Board(newBoard);
                }
            }
        }
        throw new IllegalMoveException("Invalid move");
    }
}
