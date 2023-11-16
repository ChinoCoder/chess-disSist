package Games.Chess.Helpers;

import Games.Chess.Factories.PieceFactory;
import Games.Chess.Type;
import Games.Commons.Color;
import Games.Commons.Helpers.PromoteHelper;
import Games.Commons.Piece;

public class ChessPromotionHelper extends PromoteHelper {
    public ChessPromotionHelper(Type promoteType) {
        super(promoteType);
    }

    @Override
    protected Piece newPiece(int id, Color color) {
        return PieceFactory.createPieceById(Type.QUEEN ,color, id);
    }
}
