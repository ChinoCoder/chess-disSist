package Games.Chess.Factories;

import Games.Chess.RuleValidators.EatingValidator;
import Games.Chess.RuleValidators.IsNotFriendlyFireValidator;
import Games.Chess.RuleValidators.NonEatingValidator;
import Games.Chess.Type;
import Games.Commons.Board;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Square;
import Games.Commons.Validators.AndValidator;
import Games.Commons.Validators.MovementValidators.*;
import Games.Commons.Validators.OrValidator;
import Games.Commons.Validators.Validator;

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

        final AndValidator horMove = new AndValidator(new Validator[]{new HorizontalMovementValidator(), new PieceInHorizontalMovementValidator(), new IsNotFriendlyFireValidator()});
        final AndValidator verMove = new AndValidator(new Validator[]{new VerticalMovementValidator(), new PieceInVerticalMovementValidator(), new IsNotFriendlyFireValidator()});
        final AndValidator diaMove = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new PieceInDiagonalMovementValidator(), new IsNotFriendlyFireValidator()});
        final AndValidator diaOnlyOne = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new TileMovementValidator(1), new IsNotFriendlyFireValidator()});
        final AndValidator horOnlyOne = new AndValidator(new Validator[]{new HorizontalMovementValidator(), new TileMovementValidator(1), new IsNotFriendlyFireValidator()});
        final AndValidator verOnlyOne = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new IsNotFriendlyFireValidator()});
        final AndValidator forwardOnlyOne = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});
        final AndValidator forwardOnlyOneNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new NonEatingValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});
        final AndValidator forwardOnlyTwoNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(2), new NonEatingValidator(), new PieceInVerticalMovementValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()}); // Only for the first move
        final AndValidator diaOnlyOneEatForward = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new TileMovementValidator(1), new EatingValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});

        final OrValidator QueenVali = new OrValidator(new Validator[]{horMove, verMove, diaMove});
        final OrValidator RookVali = new OrValidator(new Validator[]{horMove, verMove});
        final OrValidator BishopVali = new OrValidator(new Validator[]{diaMove});
        final OrValidator KingVali = new OrValidator(new Validator[]{horOnlyOne, verOnlyOne, diaOnlyOne});
        final OrValidator KnightVali = new OrValidator(new Validator[]{new AndValidator(new Validator[]{new HorseJumpValidator(), new IsNotFriendlyFireValidator()})});
        final OrValidator PawnVali = new OrValidator(new Validator[]{forwardOnlyOneNoEat, forwardOnlyTwoNoEat, diaOnlyOneEatForward});


        Map<Square, Piece> board = new HashMap<>();

        board.put(squares[0], new Piece(1, Type.ROOK, Color.WHITE, RookVali));
        board.put(squares[1], new Piece(2, Type.KNIGHT, Color.WHITE, KnightVali));
        board.put(squares[2], new Piece(3, Type.BISHOP, Color.WHITE, BishopVali));
        board.put(squares[3], new Piece(4, Type.QUEEN, Color.WHITE, QueenVali));
        board.put(squares[4], new Piece(5, Type.KING, Color.WHITE, KingVali));
        board.put(squares[5], new Piece(6, Type.BISHOP, Color.WHITE, BishopVali));
        board.put(squares[6], new Piece(7, Type.KNIGHT, Color.WHITE, KnightVali));
        board.put(squares[7], new Piece(8, Type.ROOK, Color.WHITE, RookVali));
        board.put(squares[8], new Piece(9, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[9], new Piece(10, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[10], new Piece(11, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[11], new Piece(12, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[12], new Piece(13, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[13], new Piece(14, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[14], new Piece(15, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[15], new Piece(16, Type.PAWN, Color.WHITE, PawnVali));
        board.put(squares[48], new Piece(17, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[49], new Piece(18, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[50], new Piece(19, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[51], new Piece(20, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[52], new Piece(21, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[53], new Piece(22, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[54], new Piece(23, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[55], new Piece(24, Type.PAWN, Color.BLACK, PawnVali));
        board.put(squares[56], new Piece(25, Type.ROOK, Color.BLACK, RookVali));
        board.put(squares[57], new Piece(26, Type.KNIGHT, Color.BLACK, KnightVali));
        board.put(squares[58], new Piece(27, Type.BISHOP, Color.BLACK, BishopVali));
        board.put(squares[59], new Piece(28, Type.QUEEN, Color.BLACK, QueenVali));
        board.put(squares[60], new Piece(29, Type.KING, Color.BLACK, KingVali));
        board.put(squares[61], new Piece(30, Type.BISHOP, Color.BLACK, BishopVali));
        board.put(squares[62], new Piece(31, Type.KNIGHT, Color.BLACK, KnightVali));
        board.put(squares[63], new Piece(32, Type.ROOK, Color.BLACK, RookVali));

        return board;
    }
}
