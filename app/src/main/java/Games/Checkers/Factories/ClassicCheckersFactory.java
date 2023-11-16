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

        board.put(squares[0], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[2], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[4], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[6], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[9], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[11], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[13], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[15], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[16], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[18], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[20], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[22], CheckersPieceFactory.createNormalPiece(Color.WHITE));
        board.put(squares[41], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[43], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[45], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[47], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[48], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[50], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[52], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[54], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[57], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[59], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[61], CheckersPieceFactory.createNormalPiece(Color.BLACK));
        board.put(squares[63], CheckersPieceFactory.createNormalPiece(Color.BLACK));

        return board;
    }
}
