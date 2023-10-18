package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class VerticalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() != end.getRow()) {
            return start.getColumn() == end.getColumn();
        }
        return false;
    }
}
