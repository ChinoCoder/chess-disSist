package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class VerticalMovementValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() != end.getRow()) {
            if (start.getColumn() == end.getColumn()){
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
        return false;
    }
}
