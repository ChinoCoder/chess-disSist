package mainStuff.Validators.RuleValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Type;
import mainStuff.Validators.Validator;

public class CastlingValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        if (start.getRow() == end.getRow()) {
            if (board.getBoard().get(start).getType() == Type.KING && board.getBoard().get(end).getType() == Type.ROOK) {
                return true; //CAMBIAR AKSDJNASKJDBASKJDASKJD
            }
            else if (board.getBoard().get(start).getType() == Type.ROOK && board.getBoard().get(end).getType() == Type.KING) {
                return true; //CAMBIAR AKSDJNASKJDBASKJDASKJD
            }
            return false;
        }
        return false;
    }
}
