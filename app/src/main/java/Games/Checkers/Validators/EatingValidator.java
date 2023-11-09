package Games.Checkers.Validators;

import Games.Commons.Board;
import Games.Commons.Square;
import Games.Commons.Validators.Validator;

public class EatingValidator implements Validator {

    @Override
    public boolean isValid(Board board, Square start, Square end) {
        int middleRow;
        int middleCol;
        if (start.getRow() > end.getRow()) {
            middleRow = start.getRow() - 1;
        } else { middleRow = start.getRow() + 1; }
        if (start.getColumn() > end.getColumn()) {
            middleCol = start.getColumn() - 1;
        } else { middleCol = start.getColumn() + 1; }
        Square middle = new Square(middleRow, middleCol);
        if (board.getPieceAt(middle) != null) {
            return board.getPieceAt(middle).getColor() != board.getPieceAt(start).getColor();
        }
        return false;
    }
}
