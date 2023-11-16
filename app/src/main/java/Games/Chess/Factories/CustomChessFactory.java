package Games.Chess.Factories;

import Games.Commons.Type;
import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;

import java.util.HashMap;
import java.util.Map;

public class CustomChessFactory {

    public static Board createBoard() {
        return new Board(easyMap(), 9, 9);
    }

    private static Map<Square, Piece> createMap() {
        Square[] squares = new Square[100];

        int index = 0;

        for (int row = 1; row <= 10; row++) {
            for (int column = 1; column <= 10; column++) {
                squares[index] = new Square(row, column);
                index++;
            }
        }
        Map<Square, Piece> board = new HashMap<>();

        board.put(squares[0], PieceFactory.createPiece(Type.ROOK, Color.WHITE));
        board.put(squares[1], PieceFactory.createPiece(Type.KNIGHT, Color.WHITE));
        board.put(squares[2], PieceFactory.createPiece(Type.BISHOP, Color.WHITE));
        board.put(squares[3], PieceFactory.createPiece(Type.ARCHBISHOP, Color.WHITE));
        board.put(squares[4], PieceFactory.createPiece(Type.QUEEN, Color.WHITE));
        board.put(squares[5], PieceFactory.createPiece(Type.KING, Color.WHITE));
        board.put(squares[6], PieceFactory.createPiece(Type.ARCHBISHOP, Color.WHITE));
        board.put(squares[7], PieceFactory.createPiece(Type.BISHOP, Color.WHITE));
        board.put(squares[8], PieceFactory.createPiece(Type.KNIGHT, Color.WHITE));
        board.put(squares[9], PieceFactory.createPiece(Type.ROOK, Color.WHITE));
        board.put(squares[10], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[11], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[12], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[13], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[14], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[15], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[16], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[17], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[18], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[19], PieceFactory.createPiece(Type.PAWN, Color.WHITE));
        board.put(squares[80], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[81], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[82], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[83], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[84], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[85], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[86], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[87], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[88], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[89], PieceFactory.createPiece(Type.PAWN, Color.BLACK));
        board.put(squares[90], PieceFactory.createPiece(Type.ROOK, Color.BLACK));
        board.put(squares[91], PieceFactory.createPiece(Type.KNIGHT, Color.BLACK));
        board.put(squares[92], PieceFactory.createPiece(Type.BISHOP, Color.BLACK));
        board.put(squares[93], PieceFactory.createPiece(Type.ARCHBISHOP, Color.BLACK));
        board.put(squares[94], PieceFactory.createPiece(Type.QUEEN, Color.BLACK));
        board.put(squares[95], PieceFactory.createPiece(Type.KING, Color.BLACK));
        board.put(squares[96], PieceFactory.createPiece(Type.ARCHBISHOP, Color.BLACK));
        board.put(squares[97], PieceFactory.createPiece(Type.BISHOP, Color.BLACK));
        board.put(squares[98], PieceFactory.createPiece(Type.KNIGHT, Color.BLACK));
        board.put(squares[99], PieceFactory.createPiece(Type.ROOK, Color.BLACK));

        return board;
    }

    private static Map<Square, Piece> easyMap() {
        Square[] squares = new Square[81];

        int index = 0;

        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                squares[index] = new Square(row, column);
                index++;
            }
        }
        Map<Square, Piece> board = new HashMap<>();

        board.put(squares[0], PieceFactory.createPiece(Type.ARCHBISHOP, Color.WHITE));
        board.put(squares[1], PieceFactory.createPiece(Type.KING, Color.WHITE));
        board.put(squares[65], PieceFactory.createPiece(Type.ARCHBISHOP, Color.BLACK));
        board.put(squares[80], PieceFactory.createPiece(Type.KING, Color.BLACK));

        return board;
    }
}