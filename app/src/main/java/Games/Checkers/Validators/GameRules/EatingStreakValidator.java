package Games.Checkers.Validators.GameRules;

import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Square;
import Games.Commons.Validators.GameRuleValidator;

public class EatingStreakValidator implements GameRuleValidator {
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        return false; ///IMPLEMENT
    }

}
