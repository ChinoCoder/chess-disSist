package Games.Checkers.Validators;

import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;
import Games.Commons.Validators.Validator;

import java.util.Map;

public class CanEatValidator implements Validator {
    @Override
    public boolean isValid(Board board, Square start, Square end) {
        Piece piece = board.getPieceAt(end);
        for (int i = 1; i <= board.getRows(); i++){
            for (int j = 1; j <= board.getColumns(); j++){
                Square currentSquare = new Square(i, j);
                if (piece.getMovements().isValid(board, end, currentSquare) && new EatingValidator().isValid(board, end, currentSquare)){
                    return true;
                }
            }
        }
        return false;
    }
}
