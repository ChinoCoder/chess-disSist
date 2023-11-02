package Games.Checkers.Helpers;

import Games.Checkers.Validators.HasEatenValidator;
import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Square;

import java.util.List;

public class Helper {
    private static final HasEatenValidator hasEatenValidator = new HasEatenValidator();

    public static Game helpEat(Game game, Square start, Square end){
        if (hasEatenValidator.isValid(game, start, end)){
            int middleRow;
            int middleCol;
            if (start.getRow() > end.getRow()) {
                middleRow = start.getRow() - 1;
            } else { middleRow = start.getRow() + 1; }
            if (start.getColumn() > end.getColumn()) {
                middleCol = start.getColumn() - 1;
            } else { middleCol = start.getColumn() + 1; }
            Square middle = new Square(middleRow, middleCol);
            Board board = EatingHelper.takePiece(game.getCurrentTurn(), middle);
            List<Board> turns = new java.util.ArrayList<>(List.copyOf(game.getTurns()));
            turns.remove(turns.size()-1);
            turns.add(board);
            return new Game(turns, game.getGameRuleValidator(), game.getGameEndValidator() ,game.getCurrentTurnColor());
        }
        return game;
    }
}
