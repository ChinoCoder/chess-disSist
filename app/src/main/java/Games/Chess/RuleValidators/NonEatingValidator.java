package Games.Chess.RuleValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class NonEatingValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        return board.getPieceAt(end) == null;
    }
}
