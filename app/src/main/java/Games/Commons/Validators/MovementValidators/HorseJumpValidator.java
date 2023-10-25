package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

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
