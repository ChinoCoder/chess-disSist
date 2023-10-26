package Games.Commons.Validators.MovementValidators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class PieceInDiagonalMovementValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
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
