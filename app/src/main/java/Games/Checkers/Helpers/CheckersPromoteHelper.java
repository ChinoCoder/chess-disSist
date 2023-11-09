package Games.Checkers.Helpers;

import Games.Checkers.Factories.CheckersPieceFactory;
import Games.Chess.Factories.PieceFactory;
import Games.Chess.Type;
import Games.Commons.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckersPromoteHelper implements Helper {
    private Type promoteType;
    public CheckersPromoteHelper(Type promoteType){
        this.promoteType = promoteType;
    }
    @Override
    public Game help(Game game, Square start, Square end) {
        Board board = game.getCurrentTurn();
        Piece piece = board.getBoard().get(end);
        Map<Square, Piece> map = board.getBoard();
        Map<Square, Piece> newMap = new HashMap<>(map);
        if (end.getRow() == 1 && piece.getType() == this.promoteType && piece.getColor() == Color.BLACK){
            newMap.put(end, CheckersPieceFactory.createKingCheckerWithId(piece.getId(),piece.getColor()));
        }
        if (end.getRow() == game.getCurrentTurn().getRows() && piece.getType() == this.promoteType && piece.getColor() == Color.WHITE){
            newMap.put(end, CheckersPieceFactory.createKingCheckerWithId(piece.getId(),piece.getColor()));
        }
        Board newBoard = new Board(newMap, board.getRows(), board.getColumns());
        List<Board> turns = new java.util.ArrayList<>(List.copyOf(game.getTurns()));
        turns.remove(turns.size()-1);
        turns.add(newBoard);
        return new Game(turns, game.getGameRuleValidator(), game.getGameEndValidator() ,game.getCurrentTurnColor());
    }
}
