package mainStuff.Validators.RuleValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

public class NonEatingValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        return !board.getIfSquareHasPieceByRowAndColumn(end.getRow(), end.getColumn());
    }
}
