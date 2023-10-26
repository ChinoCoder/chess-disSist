package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class PieceInHorizontalMovementValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getColumn() > end.getColumn()){
            for (int i = start.getColumn() - 1; i > end.getColumn(); i--) {
                if (board.getIfSquareHasPieceByRowAndColumn(start.getRow(), i)) {
                    return false;
                }
            }
        }
        else {
            for (int i = start.getColumn() + 1; i < end.getColumn(); i++) {
                if (board.getIfSquareHasPieceByRowAndColumn(start.getRow(), i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
