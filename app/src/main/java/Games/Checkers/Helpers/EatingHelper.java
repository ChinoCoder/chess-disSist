package Games.Checkers.Helpers;

import Games.Commons.Board;
import Games.Commons.Piece;
import Games.Commons.Square;

import java.util.HashMap;
import java.util.Map;

public class EatingHelper {

    public static Board takePiece(Board board, Square square){
        Map<Square, Piece> map = board.getBoard();
        Map<Square, Piece> newMap = new HashMap<>(map);
        newMap.remove(square);
        return new Board(newMap, board.getRows(), board.getColumns());
    }
}
