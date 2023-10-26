package Games.Chess.RuleValidators;

import Games.Chess.Type;
import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;

import java.util.Map;

public class CheckValidator implements GameRuleValidator {
    private Type pieceType;
    public CheckValidator(Type type){
        this.pieceType = type;
    }
    @Override
    public boolean isValid(Game game) {
        Board board = game.getCurrentTurn();
        Color currentTurn = game.getCurrentTurnColor();
        Square kingSquare = getKing(board, currentTurn);
        return !isPieceChecked(board, kingSquare, currentTurn);
    }

    private boolean isPieceChecked(Board board, Square target, Color kingColor){
        for (Map.Entry<Square, Piece> entry : board.getBoard().entrySet()) {
            Square square = entry.getKey();
            if (entry.getValue().getColor() != kingColor && !board.move(square, target).getError()) {
                return true;
            }
        }
        return false;
    }

    private Square getKing(Board board, Color color){
        for (Map.Entry<Square, Piece> entry : board.getBoard().entrySet()) {
            Square square = entry.getKey();
            if (entry.getValue() != null && entry.getValue().getColor() == color && entry.getValue().getType() == this.pieceType) {
                return square;
            }
        }
        return null;
    }
}
