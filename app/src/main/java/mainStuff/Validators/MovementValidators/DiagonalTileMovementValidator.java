package mainStuff.Validators.MovementValidators;

import mainStuff.Board;
import mainStuff.Square;
import mainStuff.Validators.Validator;

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
