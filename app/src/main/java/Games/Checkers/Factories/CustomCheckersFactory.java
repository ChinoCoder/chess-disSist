package Games.Checkers.Factories;

import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;

import java.util.HashMap;
import java.util.Map;

public class CustomCheckersFactory {

    public static Board createBoard() {
        return new Board(createMap(), 8, 8);
    }

    private static Map<Square, Piece> createMap(){
        Square[] squares = new Square[64];

        int index = 0;

        for (int row = 1; row <= 8; row++) {
            for (int column = 1; column <= 8; column++) {
                squares[index] = new Square(row, column);
                index++;
            }
        }

        Map<Square, Piece> board = new HashMap<>();

        board.put(squares[15], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[1], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[29], CheckersPieceFactory.createNormalPiece(Color.BLACK));

        return board;
    }
}
