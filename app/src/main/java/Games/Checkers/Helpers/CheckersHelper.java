package Games.Checkers.Helpers;

import Games.Checkers.Validators.CanEatValidator;
import Games.Checkers.Validators.GameRules.HasEatenValidator;
import Games.Commons.Type;
import Games.Commons.Board;
import Games.Commons.Game;
import Games.Commons.Helpers.Helper;
import Games.Commons.Helpers.PromoteHelper;
import Games.Commons.Square;

import java.util.List;

public class CheckersHelper implements Helper {
    private final HasEatenValidator hasEatenValidator = new HasEatenValidator();
    private final CanEatValidator canEatValidator = new CanEatValidator();
    private final PromoteHelper checkersPromoteHelper = new CheckersPromotionHelper(Type.PAWN);

    private Game helpEat(Game game, Square start, Square end){
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
            if (canEatValidator.isValid(game.getCurrentTurn(), start, end)) {
                return new Game(turns, game.getGameRuleValidator(), game.getGameEndValidator(), game.getOppositeColor(game.getCurrentTurnColor()));
            }
            return new Game(turns, game.getGameRuleValidator(), game.getGameEndValidator() ,game.getCurrentTurnColor());
        }
        return game;
    }

    private Game helpPromote(Game game, Square start, Square end){
        if (end.getRow() == 1 || end.getRow() == game.getCurrentTurn().getRows()){
            return checkersPromoteHelper.help(game, start, end);
        }
        return game;
    }
    @Override
    public Game help(Game game, Square start, Square end) {
        Game newgame = helpEat(game, start, end);
        newgame = helpPromote(newgame, start, end);
        return newgame;
    }
}
