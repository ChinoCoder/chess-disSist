package Games.Commons.Helpers;

import Games.Commons.Type;
import Games.Commons.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PromoteHelper implements Helper {
    private Type promoteType;

    public PromoteHelper(Type promoteType){
        this.promoteType = promoteType;
    }

    protected abstract Piece newPiece(int id, Color color);
    @Override
    public Game help(Game game, Square start, Square end) {
        Board board = game.getCurrentTurn();
        Piece piece = board.getBoard().get(end);
        Map<Square, Piece> map = board.getBoard();
        Map<Square, Piece> newMap = new HashMap<>(map);
        if (end.getRow() == 1 && piece.getType() == this.promoteType && piece.getColor() == Color.BLACK){
            newMap.put(end, newPiece(piece.getId(), piece.getColor()));
        }
        if (end.getRow() == game.getCurrentTurn().getRows() && piece.getType() == this.promoteType && piece.getColor() == Color.WHITE){
            newMap.put(end, newPiece(piece.getId(), piece.getColor()));
        }
        Board newBoard = new Board(newMap, board.getRows(), board.getColumns());
        List<Board> turns = new java.util.ArrayList<>(List.copyOf(game.getTurns()));
        turns.remove(turns.size()-1);
        turns.add(newBoard);
        return new Game(turns, game.getGameRuleValidator(), game.getGameEndValidator() ,game.getCurrentTurnColor());
    }
}
