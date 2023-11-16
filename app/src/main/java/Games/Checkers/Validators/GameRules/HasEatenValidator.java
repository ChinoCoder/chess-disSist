package Games.Checkers.Validators.GameRules;

import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Square;
import Games.Commons.Validators.GameRuleValidator;

public class HasEatenValidator implements GameRuleValidator {
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        int differenceRow = Math.abs(start.getRow() - end.getRow());
        int differenceCol = Math.abs(start.getColumn() - end.getColumn());
        return differenceRow == 2 && differenceCol == 2;
    }
}
