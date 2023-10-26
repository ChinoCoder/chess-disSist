package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class ForwardMovementValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        Color color = board.getPieceAt(start).getColor();
        if (color == Color.WHITE){
            return start.getRow() < end.getRow();
        }
        return start.getRow() > end.getRow();
    }
}
