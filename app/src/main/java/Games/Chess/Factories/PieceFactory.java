package Games.Chess.Factories;

import Games.Chess.RuleValidators.EatingValidator;
import Games.Chess.RuleValidators.IsNotFriendlyFireValidator;
import Games.Commons.Validators.MovementValidators.NonEatingValidator;
import Games.Commons.Type;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Validators.AndValidator;
import Games.Commons.Validators.MovementValidators.*;
import Games.Commons.Validators.OrValidator;
import Games.Commons.Validators.Validator;

public class PieceFactory {
    private static int index = 0;
    private static final AndValidator horMove = new AndValidator(new Validator[]{new HorizontalMovementValidator(), new PieceInHorizontalMovementValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator verMove = new AndValidator(new Validator[]{new VerticalMovementValidator(), new PieceInVerticalMovementValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator diaMove = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new PieceInDiagonalMovementValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator diaOnlyOne = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new DiagonalTileMovementValidator(1), new IsNotFriendlyFireValidator()});
    private static final AndValidator horOnlyOne = new AndValidator(new Validator[]{new HorizontalMovementValidator(), new TileMovementValidator(1), new IsNotFriendlyFireValidator()});
    private static final AndValidator verOnlyOne = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new IsNotFriendlyFireValidator()});
    private static final AndValidator forwardOnlyOne = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator forwardOnlyOneNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(1), new NonEatingValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator forwardOnlyTwoNoEat = new AndValidator(new Validator[]{new VerticalMovementValidator(), new TileMovementValidator(2), new NonEatingValidator(), new PieceInVerticalMovementValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()}); // Only for the first move
    private static final AndValidator diaOnlyOneEatForward = new AndValidator(new Validator[]{new DiagonalMovementValidator(), new DiagonalTileMovementValidator(1), new EatingValidator(), new ForwardMovementValidator(), new IsNotFriendlyFireValidator()});

    public static Piece createPieceById(Type type, Color color, int id){
        return switch (type) {
            case KING -> {
                final OrValidator KingVali = new OrValidator(new Validator[]{horOnlyOne, verOnlyOne, diaOnlyOne});
                yield new Piece(id, type, color, KingVali);
            }
            case ARCHBISHOP -> {
                final OrValidator ArchbishopVali = new OrValidator(new Validator[]{new HorseJumpValidator(), diaMove});
                yield new Piece(id, type, color, ArchbishopVali);
            }
            case QUEEN -> {
                final OrValidator QueenVali = new OrValidator(new Validator[]{horMove, verMove, diaMove});
                yield new Piece(id, type, color, QueenVali);
            }
            case ROOK -> {
                final OrValidator RookVali = new OrValidator(new Validator[]{horMove, verMove});
                yield new Piece(id, type, color, RookVali);
            }
            case BISHOP -> {
                final OrValidator BishopVali = new OrValidator(new Validator[]{diaMove});
                yield new Piece(id, type, color, BishopVali);
            }
            case KNIGHT -> {
                final OrValidator KnightVali = new OrValidator(new Validator[]{new AndValidator(new Validator[]{new HorseJumpValidator(), new IsNotFriendlyFireValidator()})});
                yield new Piece(id, type, color, KnightVali);
            }
            case PAWN -> {
                final OrValidator PawnVali = new OrValidator(new Validator[]{forwardOnlyOneNoEat, forwardOnlyTwoNoEat, diaOnlyOneEatForward});
                yield new Piece(id, type, color, PawnVali);
            }
        };
    }

    public static Piece createPiece(Type type, Color color){
        index++;
        return createPieceById(type, color, index);
    }
}
