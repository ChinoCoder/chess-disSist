package Games.Checkers.Validators.GameRules;

import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;

import java.util.Map;

public class NoPossibleMovesValidator implements GameRuleValidator {
    @Override
    public boolean isValid(Game game, Square start, Square end) {
        Board currentBoard = game.getCurrentTurn();
        Color currentColor = game.getCurrentTurnColor();
        for (int i = 1; i <= currentBoard.getRows(); i++){
            for (int j = 1; j <= currentBoard.getColumns(); j++){
                Square currentSquare = new Square(i, j);
                for(Map.Entry<Square, Piece> piece : currentBoard.getBoard().entrySet()){
                    if (piece.getValue().getColor() == currentColor && piece.getValue().getMovements().isValid(currentBoard, piece.getKey(), currentSquare)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
