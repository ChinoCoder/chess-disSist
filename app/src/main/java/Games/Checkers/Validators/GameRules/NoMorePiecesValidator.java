package Games.Checkers.Validators.GameRules;

import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Piece;
import Games.Commons.Square;
import Games.Commons.Validators.GameRuleValidator;

import java.util.Map;

public class NoMorePiecesValidator implements GameRuleValidator {
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        Board currentBoard = game.getCurrentTurn();
        for(Map.Entry<Square, Piece> piece : currentBoard.getBoard().entrySet()){
            if (piece.getValue().getColor() == game.getCurrentTurnColor()){
                return false;
            }
        }
        return true;
    }
}
