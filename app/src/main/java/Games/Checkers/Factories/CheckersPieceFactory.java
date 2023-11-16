package Games.Checkers.Factories;

import Games.Checkers.Validators.EatingValidator;
import Games.Chess.RuleValidators.IsNotFriendlyFireValidator;
import Games.Commons.Type;
import Games.Commons.Color;
import Games.Commons.Piece;
import Games.Commons.Validators.AndValidator;
import Games.Commons.Validators.MovementValidators.DiagonalTileMovementValidator;
import Games.Commons.Validators.MovementValidators.ForwardMovementValidator;
import Games.Commons.Validators.MovementValidators.NonEatingValidator;
import Games.Commons.Validators.OrValidator;
import Games.Commons.Validators.Validator;

public class CheckersPieceFactory{
    private static int index = 0;

    private static final AndValidator nonEatingDiagonal = new AndValidator(new Validator[]{new DiagonalTileMovementValidator(1), new ForwardMovementValidator(), new NonEatingValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator nonEatingDiagonalKing = new AndValidator(new Validator[]{new DiagonalTileMovementValidator(1), new NonEatingValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator eatingDiagonal = new AndValidator(new Validator[]{new DiagonalTileMovementValidator(2), new EatingValidator(), new ForwardMovementValidator() , new NonEatingValidator(), new IsNotFriendlyFireValidator()});
    private static final AndValidator eatingDiagonalKing = new AndValidator(new Validator[]{new DiagonalTileMovementValidator(2), new EatingValidator(), new NonEatingValidator(), new IsNotFriendlyFireValidator()});
    private static final OrValidator commonVali = new OrValidator(new Validator[]{nonEatingDiagonal, eatingDiagonal});
    private static final OrValidator kingVali = new OrValidator(new Validator[]{eatingDiagonalKing, nonEatingDiagonalKing});
    public static Piece createNormalPiece(Color color) {
        index++;
        return new Piece(index, Type.PAWN, color, commonVali);
    }

    public static Piece createKingChecker(Color color){
        index++;
        return new Piece(index, Type.KING, color, kingVali);
    }

    public static Piece createKingCheckerWithId(int id,Color color){
        return new Piece(id, Type.KING, color, kingVali);
    }
}
