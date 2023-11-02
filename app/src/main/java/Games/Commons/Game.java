package Games.Commons;

import Games.Commons.Validators.AndValidator;
import Games.Commons.Validators.GameRuleValidator;

import java.util.List;
import java.util.Optional;

public class Game {
    private final List<Board> turns;
    private final List<Piece> capturedPieces;
    private final GameRuleValidator gameRuleValidator;
    private final GameRuleValidator gameEndValidator;

    private final Color currentTurn;

    public Game(Board board, GameRuleValidator gameRuleValidator, GameRuleValidator gameEndValidator, Color turn) {
        this.gameRuleValidator = gameRuleValidator;
        this.gameEndValidator = gameEndValidator;
        Board[] aux = new Board[]{board};
        this.turns = List.of(aux);
        this.capturedPieces = List.of();
        this.currentTurn = turn;
    }

    public Game(List<Board> turns, GameRuleValidator gameRuleValidator, GameRuleValidator gameEndValidator, Color currentTurn) {
        this.turns = turns;
        this.gameEndValidator = gameEndValidator;
        this.currentTurn = currentTurn;
        this.capturedPieces = List.of();
        this.gameRuleValidator = gameRuleValidator;
    }

    private Game(List<Board> turns, List<Piece> capturedPieces, GameRuleValidator gameRuleValidator, GameRuleValidator gameEndValidator, Color currentTurn) {
        this.turns = turns;
        this.capturedPieces = capturedPieces;
        this.gameEndValidator = gameEndValidator;
        this.currentTurn = currentTurn;
        this.gameRuleValidator = gameRuleValidator;
    }

    public Result<Game, Boolean> move(Square start, Square end){
        Piece piece = getPieceAt(start);
        Piece pieceEaten = getPieceAt(end);
        if (piece != null) {
            if (piece.getColor() != getCurrentTurnColor()) {
                return new Result<>(Optional.empty(), true);
            }
            Result<Board, Boolean> result = getCurrentTurn().move(start, end);
            List<Board> newTurns = new java.util.ArrayList<>(List.copyOf(turns));
            if (result.getError()) {
                return new Result<>(Optional.empty(), true);
            }
            Board newBoard = result.getValue().get();
            newTurns.add(newBoard);
            Game newGame = new Game(newTurns, this.gameRuleValidator, gameEndValidator, getOppositeColor(currentTurn));
            if (pieceEaten != null) {
                List<Piece> newCapturedPieces = new java.util.ArrayList<>(List.copyOf(capturedPieces));
                newCapturedPieces.add(pieceEaten);
                return new Result<>(Optional.of(new Game(newTurns, newCapturedPieces, this.gameRuleValidator, gameEndValidator, getOppositeColor(currentTurn))), false);
            } else {
                return new Result<>(Optional.of(newGame), false);
            }
        }
        else return new Result<>(Optional.empty(), true);
    }

    public Board getCurrentTurn() {
        return turns.get(turns.size() - 1);
    }

    public Color getOppositeColor(Color color){
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public Color getCurrentTurnColor() {
        return currentTurn;
    }

    private Piece getPieceAt(Square square) {
        return getCurrentTurn().getPieceAt(square);
    }

    public List<Board> getTurns() {
        return turns;
    }

    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public GameRuleValidator getGameRuleValidator() {
        return gameRuleValidator;
    }

    public GameRuleValidator getGameEndValidator() {
        return gameEndValidator;
    }
}
