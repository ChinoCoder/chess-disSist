package Games.Chess.Factories;

import Games.Chess.Type;
import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;

import java.util.HashMap;
import java.util.Map;

public class ClassicChessFactory{

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

        board.put(squares[0], PieceFactory.createPiece(Type.ROOK, Color.WHITE));
        board.put(squares[1], PieceFactory.createPiece(Type.KNIGHT, Color.WHITE));
        board.put(squares[2], PieceFactory.createPiece(Type.BISHOP, Color.WHITE));
        board.put(squares[3], PieceFactory.createPiece(Type.QUEEN, Color.WHITE));
        board.put(squares[4], PieceFactory.createPiece(Type.KING, Color.WHITE));
        board.put(squares[5], PieceFactory.createPiece(Type.BISHOP, Color.WHITE));
        board.put(squares[6], PieceFactory.createPiece(Type.KNIGHT, Color.WHITE));
        board.put(squares[7], PieceFactory.createPiece(Type.ROOK, Color.WHITE));
        board.put(squares[8], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[9], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[10], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[11], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[12], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[13], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[14], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[15], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[48], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[49], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[50], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[51], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[52], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[53], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[54], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[55], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[56], PieceFactory.createPiece(Type.ROOK, Color.BLACK));
        board.put(squares[57], PieceFactory.createPiece(Type.KNIGHT, Color.BLACK));
        board.put(squares[58], PieceFactory.createPiece(Type.BISHOP, Color.BLACK));
        board.put(squares[59], PieceFactory.createPiece(Type.QUEEN, Color.BLACK));
        board.put(squares[60], PieceFactory.createPiece(Type.KING, Color.BLACK));
        board.put(squares[61], PieceFactory.createPiece(Type.BISHOP, Color.BLACK));
        board.put(squares[62], PieceFactory.createPiece(Type.KNIGHT, Color.BLACK));
        board.put(squares[63], PieceFactory.createPiece(Type.ROOK, Color.BLACK));

        return board;
    }
}
