package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class HorizontalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getColumn() != end.getColumn()) {
            return start.getRow() == end.getRow();
        }
        return false;
    }
}
