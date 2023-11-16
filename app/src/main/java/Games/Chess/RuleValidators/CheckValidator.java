package Games.Chess.RuleValidators;

import Games.Commons.Type;
import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;

import java.util.Map;

public class CheckValidator implements GameRuleValidator {
    private final Type pieceType;
    public CheckValidator(Type type){
        this.pieceType = type;
    }
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        Board currentBoard = game.getCurrentTurn();
        Map<Square, Piece> pieces = currentBoard.getBoard();
        Piece movedPiece = pieces.get(end);

        Square kingsSq = getCheckablePiece(currentBoard, movedPiece.getColor());
        if(kingsSq == null) return true;
        Color enemyColor = movedPiece.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE;

        for(Map.Entry<Square, Piece> piece : pieces.entrySet()){
            Square from = piece.getKey();
            if(piece.getValue().getColor() == enemyColor && piece.getValue().getMovements().isValid(currentBoard, from, kingsSq)) return false;
        }

        return true;
    }

    private Square getCheckablePiece(Board board, Color color){
        for (Map.Entry<Square, Piece> entry : board.getBoard().entrySet()) {
            Square square = entry.getKey();
            if (entry.getValue() != null && entry.getValue().getColor() == color && entry.getValue().getType() == this.pieceType) {
                return square;
            }
        }
        return null;
    }
}
