package mainStuff.Validators;

import mainStuff.Board;
import mainStuff.Square;

public class AndValidator implements Validator{
    private final Validator[] validators;

    public AndValidator(Validator[] validators) {
        this.validators = validators;
    }

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        for (Validator validator : validators) {
            if (!validator.isValid(board, start, end)) {
                return false;
            }
        }
        return true;
    }
}
