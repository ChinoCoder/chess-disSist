package GameEngine;

import edu.austral.dissis.chess.gui.*;
import mainStuff.*;
import mainStuff.Validators.AndValidator;
import mainStuff.Validators.MovementValidators.*;
import mainStuff.Validators.OrValidator;
import mainStuff.Validators.RuleValidators.EatingValidator;
import mainStuff.Validators.RuleValidators.NonEatingValidator;
import mainStuff.Validators.Validator;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class gameEngine implements GameEngine {

    private final Map<Square, Piece> initboard = createClassicChessboard();
    private final Board ClassicBoard = new Board(initboard, 8, 8);
    private final Game ClassicGame = new Game(ClassicBoard);
    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Square[] ToFrom = Adapter.convertMove(move);
        Result<Game, Boolean> result = ClassicGame.move(ToFrom[0], ToFrom[1]);
        if (result.getError()){
            return new InvalidMove("Invalid Move");
        }
        return new NewGameState(Adapter.getCurrentPieces(result.getValue().get().getCurrentTurn()), Adapter.getCurrentTurn(result.getValue().get()));
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(Adapter.getBoardSize(ClassicGame.getCurrentTurn()), Adapter.getCurrentPieces(ClassicGame.getCurrentTurn()), Adapter.getCurrentTurn(ClassicGame));
    }

    private Map<Square, Piece> createClassicChessboard() {
        Square[] squares = new Square[64]; // Chessboard has 64 squares

        int index = 0;

        for (int row = 1; row <= 8; row++) {
            for (int column = 1; column <= 8; column++) {
                squares[index] = new Square(column, row);
                index++;
            }
        }

        final AndValidator horMove = new AndValidator(new Validator[]{new HorizontalMovementValidator()});
        final AndValidator verMove = new AndValidator(new Validator[]{new VerticalMovementValidator()});
        final AndValidator diaMove = new AndValidator(new Validator[]{new DiagonalMovementValidator()});
        final AndValidator diaOnlyOne = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new TileMovementValidator(1)});
        final AndValidator horOnlyOne = new AndValidator(new Validator[]{new HorizontalMovementValidator(), new TileMovementValidator(1)});
        final AndValidator verOnlyOne = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1)});
        final AndValidator verOnlyOneNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new NonEatingValidator()});
        final AndValidator verOnlyTwoNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(2), new NonEatingValidator()}); // Only for the first move
        final AndValidator diaOnlyOneEat = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new TileMovementValidator(1), new EatingValidator()});

        final OrValidator QueenVali = new OrValidator(new Validator[]{horMove, verMove, diaMove});
        final OrValidator RookVali = new OrValidator(new Validator[]{horMove, verMove});
        final OrValidator BishopVali = new OrValidator(new Validator[]{diaMove});
        final OrValidator KingVali = new OrValidator(new Validator[]{horOnlyOne, verOnlyOne, diaOnlyOne});
        final OrValidator KnightVali = new OrValidator(new Validator[]{new HorseJumpValidator()});
        final OrValidator PawnVali = new OrValidator(new Validator[]{verOnlyOneNoEat, verOnlyTwoNoEat, diaOnlyOneEat});


        Map<Square, Piece> board = new HashMap<>();
        for (Square square : squares) {
            board.put(square, null);
        }
        // Add the initial chess pieces
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
