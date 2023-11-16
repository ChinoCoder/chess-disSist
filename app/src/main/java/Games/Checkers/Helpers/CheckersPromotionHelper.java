package Games.Checkers.Helpers;

import Games.Checkers.Factories.CheckersPieceFactory;
import Games.Chess.Type;
import Games.Commons.Color;
import Games.Commons.Helpers.PromoteHelper;
import Games.Commons.Piece;

public class CheckersPromotionHelper extends PromoteHelper {
    public CheckersPromotionHelper(Type promoteType) {
        super(promoteType);
    }

    @Override
    protected Piece newPiece(int id, Color color) {
        return CheckersPieceFactory.createKingCheckerWithId(id, color);
    }
}
