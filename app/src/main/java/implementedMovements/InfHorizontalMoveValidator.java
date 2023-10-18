package implementedMovements;

import mainStuff.Board;
import mainStuff.MovementValidator;
import mainStuff.Piece;
import mainStuff.Square;

public class InfHorizontalMoveValidator implements MovementValidator {

    @Override
    public boolean validateMove(Board board, Square start, Square end) {
        Piece piece = board.getBoard().get(start);
        if (start.getColumn() != end.getColumn()){
            if (start.getRow() == end.getRow()){
                return piece != null;
            }
        }
        return false;
    }
}
