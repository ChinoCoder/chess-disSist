package Games.Commons.Validators;

import Games.Commons.Board;
import Games.Commons.Square;

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
