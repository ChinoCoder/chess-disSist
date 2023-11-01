package Games.Chess.RuleValidators;

import Games.Chess.Type;
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
        Color enemyColor = movedPiece.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE;

        for(Map.Entry<Square, Piece> piece : pieces.entrySet()){
            Square from = piece.getKey();
            if(piece.getValue().getColor() == enemyColor && piece.getValue().getMovements().isValid(currentBoard, from, kingsSq)) return false;
        }

        return true;
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
