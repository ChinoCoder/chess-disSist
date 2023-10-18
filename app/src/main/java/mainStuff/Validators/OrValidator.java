package mainStuff.Validators;

import mainStuff.Board;
import mainStuff.Square;

public class OrValidator implements Validator{
    private final Validator[] validators;

    public OrValidator(Validator[] validators) {
        this.validators = validators;
    }

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        for (Validator validator : validators) {
            if (validator.isValid(board, start, end)) {
                return true;
            }
        }
        return false;
    }
}
