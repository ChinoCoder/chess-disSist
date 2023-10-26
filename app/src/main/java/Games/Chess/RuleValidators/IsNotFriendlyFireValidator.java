package Games.Chess.RuleValidators;

import Games.Commons.Board;
import Games.Commons.Piece;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class IsNotFriendlyFireValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        Piece endpiece = board.getPieceAt(end);
        if(endpiece != null){
            return endpiece.getColor() != board.getPieceAt(start).getColor();
        }
        return true;
    }
}
