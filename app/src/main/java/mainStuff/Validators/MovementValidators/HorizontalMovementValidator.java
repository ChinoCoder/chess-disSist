package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class HorizontalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getColumn() != end.getColumn()) {
            return start.getRow() == end.getRow();
        }
        return false;
    }
}
