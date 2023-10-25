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
            if (start.getRow() + distance == end.getRow() || start.getRow() - distance == end.getRow()){
                if (distance > 1){
                    if (start.getRow() + distance == end.getRow()){
                        for (int i = start.getRow() + 1; i < end.getRow(); i++) {
                            if (board.getIfSquareHasPieceByRowAndColumn(i, start.getColumn())) {
                                return false;
                            }
                        }
                    }
                    else {
                        for (int i = start.getRow() - 1; i > end.getRow(); i--) {
                            if (board.getIfSquareHasPieceByRowAndColumn(i, start.getColumn())) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        if (start.getRow() == end.getRow()){
            if (start.getColumn() + distance == end.getColumn() || start.getColumn() - distance == end.getColumn()){
                if (distance > 1){
                    if (start.getColumn() + distance == end.getColumn()){
                        for (int i = start.getColumn() + 1; i < end.getColumn(); i++) {
                            if (board.getIfSquareHasPieceByRowAndColumn(start.getRow(), i)) {
                                return false;
                            }
                        }
                    }
                    else {
                        for (int i = start.getColumn() - 1; i > end.getColumn(); i--) {
                            if (board.getIfSquareHasPieceByRowAndColumn(start.getRow(), i)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
