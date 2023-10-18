package mainStuff.Validators;

import mainStuff.Board;
import mainStuff.Square;

public interface Validator {
    public boolean isValid(Board board, Square start, Square end);
}
