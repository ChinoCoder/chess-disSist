package Games.Commons.Validators;

import Games.Commons.Game;
import Games.Commons.Square;

public class GameRuleAndValidator implements GameRuleValidator{
    private GameRuleValidator[] validators;

    public GameRuleAndValidator(GameRuleValidator[] validators){
        this.validators = validators;
    }
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        for (GameRuleValidator validator : validators){
            if (!validator.isValid(game, start, end)){
                return false;
            }
        }
        return true;
    }
}
