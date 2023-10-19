package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class HorizontalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getColumn() != end.getColumn()) {
            if (start.getRow() == end.getRow()) {
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
        return false;
    }
}
