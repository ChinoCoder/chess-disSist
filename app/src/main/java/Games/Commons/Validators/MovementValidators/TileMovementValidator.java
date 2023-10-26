package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class TileMovementValidator implements Validator {
    private final int distance;

    public TileMovementValidator(int distance) {
        this.distance = distance;
    }
    @Override
    public boolean isValid(Board board, Square start, Square end) {

        if (start.getColumn() == end.getColumn()){
            return (start.getRow() + distance == end.getRow() || start.getRow() - distance == end.getRow());
        }
        if (start.getRow() == end.getRow()){
            return start.getColumn() + distance == end.getColumn() || start.getColumn() - distance == end.getColumn();
        }
        return false;
    }
}
