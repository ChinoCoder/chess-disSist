package mainStuff;

import Exceptions.IllegalMoveException;

import java.util.List;
import java.util.Optional;

public class Game {
    private final List<Board> turns;
    private final List<Piece> capturedPieces;

    public Game(Board board) {
        Board[] aux = new Board[]{board};
        this.turns = List.of(aux);
        this.capturedPieces = List.of();
    }

    private Game(List<Board> turns) {
        this.turns = turns;
        this.capturedPieces = List.of();
    }

    private Game(List<Board> turns, List<Piece> capturedPieces) {
        this.turns = turns;
        this.capturedPieces = capturedPieces;
    }

    public Result<Game, Boolean> move(Square start, Square end) throws IllegalMoveException {
        if (getPieceAt(start).getColor() != getCurrentTurnColor()) {
            return new Result<>(Optional.empty(), true);
        }
        Result<Board, Boolean> result = getCurrentTurn().move(start, end);
        List<Board> newTurns = new java.util.ArrayList<>(List.copyOf(turns));
        if (result.getError()){
            return new Result<>(Optional.empty(), true);
        }
        Board newBoard = result.getValue().get();
        newTurns.add(newBoard);
        if (newBoard.getBoard().get(end) != null) {
            List<Piece> newCapturedPieces = new java.util.ArrayList<>(List.copyOf(capturedPieces));
            newCapturedPieces.add(newBoard.getBoard().get(end));
            return new Result<>(Optional.of(new Game(newTurns, newCapturedPieces)), false);
        }
        else { return new Result<>(Optional.of(new Game(newTurns)), false); }
    }

    public Board getCurrentTurn() {
        return turns.get(turns.size() - 1);
    }

    public Color getCurrentTurnColor() {
        return turns.size() % 2 != 0 ? Color.WHITE : Color.BLACK;
    }

    private Piece getPieceAt(Square square) {
        return getCurrentTurn().getBoard().get(square);
    }

    public List<Board> getTurns() {
        return turns;
    }
}
