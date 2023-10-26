package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class PieceInVerticalMovementValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() > end.getRow()){
            for (int i = start.getRow() - 1; i > end.getRow(); i--) {
                if (board.getIfSquareHasPieceByRowAndColumn(i, start.getColumn())) {
                    return false;
                }
            }
        }
        else {
            for (int i = start.getRow() + 1; i < end.getRow(); i++) {
                if (board.getIfSquareHasPieceByRowAndColumn(i, start.getColumn())) {
                    return false;
                }
            }
        }
        return true;
    }
}
