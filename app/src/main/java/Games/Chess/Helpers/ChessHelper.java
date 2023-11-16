package Games.Chess.Helpers;

import Games.Commons.Type;
import Games.Commons.Game;
import Games.Commons.Helpers.Helper;
import Games.Commons.Square;

public class ChessHelper implements Helper {
    private final ChessPromotionHelper promotionHelper = new ChessPromotionHelper(Type.PAWN);

    private Game helpPromote(Game game, Square start, Square end){
        if (end.getRow() == 1 || end.getRow() == game.getCurrentTurn().getRows()){
            return promotionHelper.help(game, start, end);
        }
        return game;
    }
    @Override
    public Game help(Game game, Square start, Square end) {
        Game newGame = helpPromote(game, start, end);
        return newGame;
    }
}
