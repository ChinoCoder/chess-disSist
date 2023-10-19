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

        if (rowDistance == colDistance && rowDistance == distance){
            return CheckforPieceDiagonally(board, start, end);
        }
        return false;
    }

    static boolean CheckforPieceDiagonally(Board board, Square start, Square end) {
        if (start.getRow() > end.getRow()){
            if (start.getColumn() > end.getColumn()){
                for (int i = start.getRow() - 1, j = start.getColumn() - 1; i > end.getRow(); i--, j--) {
                    if (board.getIfSquareHasPieceByRowAndColumn(i, j)) {
                        return false;
                    }
                }
            }
            else {
                for (int i = start.getRow() - 1, j = start.getColumn() + 1; i > end.getRow(); i--, j++) {
                    if (board.getIfSquareHasPieceByRowAndColumn(i, j)) {
                        return false;
                    }
                }
            }
        }
        else {
            if (start.getColumn() > end.getColumn()){
                for (int i = start.getRow() + 1, j = start.getColumn() - 1; i < end.getRow(); i++, j--) {
                    if (board.getIfSquareHasPieceByRowAndColumn(i, j)) {
                        return false;
                    }
                }
            }
            else {
                for (int i = start.getRow() + 1, j = start.getColumn() + 1; i < end.getRow(); i++, j++) {
                    if (board.getIfSquareHasPieceByRowAndColumn(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
