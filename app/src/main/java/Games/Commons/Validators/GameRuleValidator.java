package Games.Commons.Validators;

import Games.Commons.Game;
import Games.Commons.Square;

public interface GameRuleValidator {

    public boolean isValid(Game game, Square start, Square end);
}
