package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class DiagonalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() != end.getRow() && start.getColumn() != end.getColumn()) {
            return Math.abs(start.getRow() - end.getRow()) == Math.abs(start.getColumn() - end.getColumn());
        }
        return false;
    }
}
