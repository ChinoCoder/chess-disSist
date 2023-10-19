package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

import static mainStuff.Validators.MovementValidators.DiagonalTileMovementValidator.CheckforPieceDiagonally;

public class DiagonalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() != end.getRow() && start.getColumn() != end.getColumn()) {
            if (Math.abs(start.getRow() - end.getRow()) == Math.abs(start.getColumn() - end.getColumn())){
                return CheckforPieceDiagonally(board, start, end);
            }
        }
        return false;
    }
}
