package Games.Chess.RuleValidators;

import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckMateValidator implements GameRuleValidator {

    private final GameRuleValidator checkValidator;

    public CheckMateValidator(GameRuleValidator checkValidator) {
        this.checkValidator = checkValidator;
    }

    @Override
    public boolean isValid(Game game, Square start, Square end) {
        Board previousBoard = game.getTurns().get(game.getTurns().size() - 2);
        Color currentPlayer = previousBoard.getBoard().get(start).getColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
        Board currentBoard = game.getTurns().get(game.getTurns().size() - 1);
        Map<Square, Piece> pieces = currentBoard.getBoard();

        for (int row = 1; row <= currentBoard.getRows(); row ++){
            for (int column = 1; column <= currentBoard.getColumns(); column++){
                Square currentDestination = new Square(row, column);
                for(Map.Entry<Square, Piece> piece : pieces.entrySet()){
                    Square from = piece.getKey();
                    if (piece.getValue().getColor() == currentPlayer && piece.getValue().getMovements().isValid(currentBoard, from, currentDestination)) {
                        //Board newBoard = currentBoard.move(from, currentDestination).getValue().get();
                        //List<Board> newHistory = new ArrayList<>(game.getTurns());
                        //newHistory.add(newBoard);
                        Game newGame = game.move(from, currentDestination).getValue().get();
                        if (checkValidator.isValid(newGame, from, currentDestination)) return false;
                    }
                }
            }
        }
        return true;
    }
}
