package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class DiagonalTileMovementValidator implements Validator {
    private final int distance;

    public DiagonalTileMovementValidator(int distance) {
        this.distance = distance;
    }
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        int rowDistance = Math.abs(start.getRow() - end.getRow());
        int colDistance = Math.abs(start.getColumn() - end.getColumn());

        return rowDistance == colDistance && rowDistance == distance;
    }

}
