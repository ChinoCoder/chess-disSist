package GameEngine;
import Games.Checkers.Helpers.Helper;
import Games.Checkers.Validators.NoMorePiecesValidator;
import Games.Checkers.Validators.NoPossibleMovesValidator;
import Games.Chess.Factories.CustomChessFactory;
import Games.Chess.RuleValidators.CheckValidator;
import Games.Chess.Type;
import Games.Commons.*;
import Games.Commons.Validators.GameRuleOrValidator;
import Games.Commons.Validators.GameRuleValidator;
import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;

public class checkersGameEngine implements GameEngine {
    private Game game;
    public checkersGameEngine() {
        Board classicBoard = CustomChessFactory.createBoard();
        this.game = new Game(classicBoard, new CheckValidator(Type.KING), new GameRuleOrValidator(new GameRuleValidator[]{new NoMorePiecesValidator(), new NoPossibleMovesValidator()}), Color.BLACK);
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Game current = this.game;
        Square[] ToFrom = Adapter.convertMove(move);
        Square start = ToFrom[0];
        Square end = ToFrom[1];
        Result<Game, Boolean> result = current.move(start, end);

        if (result.getError()){
            return new InvalidMove("Invalid Move");
        } else {
            Game newGame = Helper.helpEat(result.getValue().get(), start, end);
            if ( newGame.getGameEndValidator().isValid(newGame, start, end)) {
                return new GameOver(Adapter.getCurrentTurn(current));
            }
            //if ( newGame.getCurrentTurn().getBoard().size() != result.getValue().get().getCurrentTurn().getBoard().size()){
                //implement
            //}
            this.game = newGame;
            return new NewGameState(Adapter.getCurrentPieces(this.game.getCurrentTurn()), Adapter.getCurrentTurn(this.game));
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(Adapter.getBoardSize(this.game.getCurrentTurn()), Adapter.getCurrentPieces(this.game.getCurrentTurn()), Adapter.getCurrentTurn(this.game));
    }
}
