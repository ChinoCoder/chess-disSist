package Games.Chess.RuleValidators;

import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class IsInInitialPositionValidator implements Validator {
    private Game game;

    public IsInInitialPositionValidator(Game game) {
        this.game = game;
    }
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (game.getTurns().size() > 1) {
            int size = game.getTurns().size();
            for (int i = 0; i < size - 1; i++) {
                if (game.getTurns().get(i).getBoard().get(start) == board.getBoard().get(start)) {
                    return false;
                }
            }
        }
        return true;
    }
}
