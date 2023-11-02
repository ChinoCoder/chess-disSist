package GameEngine;

import Games.Checkers.Factories.ClassicCheckersFactory;
import Games.Checkers.Factories.CustomCheckersFactory;
import Games.Checkers.Helpers.Helper;
import Games.Checkers.Validators.NoMorePiecesValidator;
import Games.Checkers.Validators.NoPossibleMovesValidator;
import Games.Chess.Factories.ClassicChessFactory;
import Games.Chess.RuleValidators.CheckMateValidator;
import Games.Chess.RuleValidators.CheckValidator;
import Games.Chess.Type;
import Games.Commons.*;
import Games.Commons.Validators.GameRuleOrValidator;
import Games.Commons.Validators.GameRuleValidator;
import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class checkersGameEngine implements GameEngine {
    private Game game;
    private final Stack<Game> gameStack =new Stack<>();
    public checkersGameEngine() {
        this.game = ClassicGame;
        gameStack.push(this.game);
    }
    private final Board ClassicBoard = ClassicCheckersFactory.createBoard();
    private final Game ClassicGame = new Game(ClassicBoard, new CheckValidator(Type.KING), new GameRuleOrValidator(new GameRuleValidator[]{new NoMorePiecesValidator(), new NoPossibleMovesValidator()}), Color.BLACK);

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Game current=gameStack.peek();
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
            gameStack.pop();
            gameStack.push(newGame);
            return new NewGameState(Adapter.getCurrentPieces(gameStack.peek().getCurrentTurn()), Adapter.getCurrentTurn(gameStack.peek()));
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(Adapter.getBoardSize(ClassicGame.getCurrentTurn()), Adapter.getCurrentPieces(ClassicGame.getCurrentTurn()), Adapter.getCurrentTurn(ClassicGame));
    }
}
