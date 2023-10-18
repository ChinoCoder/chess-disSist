package mainStuff;

import Exceptions.IllegalMoveException;

import java.util.List;

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

    public Game move(Square start, Square end) throws IllegalMoveException {
        if (getPieceAt(start).getColor() != getCurrentTurnColor()) {
            throw new IllegalMoveException("Not your turn");
        }
        Board newBoard = getCurrentTurn().move(start, end);
        List<Board> newTurns = new java.util.ArrayList<>(List.copyOf(turns));
        newTurns.add(newBoard);
        if (newBoard.getBoard().get(end) != null) {
            List<Piece> newCapturedPieces = new java.util.ArrayList<>(List.copyOf(capturedPieces));
            newCapturedPieces.add(newBoard.getBoard().get(end));
            return new Game(newTurns, newCapturedPieces);
        }
        else { return new Game(newTurns); }
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
}
