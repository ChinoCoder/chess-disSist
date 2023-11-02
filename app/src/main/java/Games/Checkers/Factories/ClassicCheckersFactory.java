package Games.Checkers.Factories;

import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;

import java.util.HashMap;
import java.util.Map;

public class ClassicCheckersFactory {

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

        board.put(squares[1], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[3], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[5], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[7], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[8], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[10], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[12], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[14], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[17], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[19], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[21], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[23], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[40], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[42], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[44], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[46], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[49], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[51], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[53], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[55], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[56], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[58], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[60], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[62], CheckersPieceFactory.createNormalPiece(Color.BLACK));

        return board;
    }
}
