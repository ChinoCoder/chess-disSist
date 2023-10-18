package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class HorseJumpValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() != end.getRow() && start.getColumn() != end.getColumn()) {
            return Math.abs(start.getRow() - end.getRow()) == 2 && Math.abs(start.getColumn() - end.getColumn()) == 1 ||
                    Math.abs(start.getRow() - end.getRow()) == 1 && Math.abs(start.getColumn() - end.getColumn()) == 2;
        }
        return false;
    }
}
