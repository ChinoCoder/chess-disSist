package GameEngine;

import Games.Chess.RuleValidators.CheckValidator;
import Games.Chess.Type;
import Games.Commons.*;
import Games.Commons.Validators.GameRuleValidator;
import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;
import Games.Chess.Factories.ClassicChessFactory;


import java.util.Stack;

public class chessGameEngine implements GameEngine {

    private Game game;
    private final Stack<Game> gameStack =new Stack<>();
    public chessGameEngine() {
        this.game = ClassicGame;
        gameStack.push(this.game);
    }
    private final Board ClassicBoard = ClassicChessFactory.createBoard();
    private final Game ClassicGame = new Game(ClassicBoard, new CheckValidator(Type.KING), Color.WHITE);

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Game current=gameStack.peek();
        Square[] ToFrom = Adapter.convertMove(move);
        Result<Game, Boolean> result = current.move(ToFrom[0], ToFrom[1]);

        if (result.getError()){
            return new InvalidMove("Invalid Move");
        }
        gameStack.pop();
        gameStack.push(result.getValue().get());
        return new NewGameState(Adapter.getCurrentPieces(gameStack.peek().getCurrentTurn()), Adapter.getCurrentTurn(gameStack.peek()));
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(Adapter.getBoardSize(ClassicGame.getCurrentTurn()), Adapter.getCurrentPieces(ClassicGame.getCurrentTurn()), Adapter.getCurrentTurn(ClassicGame));
    }
}
