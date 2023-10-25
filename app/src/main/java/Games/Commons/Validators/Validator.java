package Games.Commons.Validators;

import Games.Commons.Board;
import Games.Commons.Square;

public interface Validator {
    public boolean isValid(Board board, Square start, Square end);
}
