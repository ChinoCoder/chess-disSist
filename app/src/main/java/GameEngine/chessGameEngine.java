package GameEngine;

import Games.Chess.Factories.CustomChessFactory;
import Games.Chess.RuleValidators.CheckMateValidator;
import Games.Chess.RuleValidators.CheckValidator;
import Games.Chess.Type;
import Games.Commons.*;
import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;
public class chessGameEngine implements GameEngine {

    private Game game;

    public chessGameEngine() {
        Board classicBoard = CustomChessFactory.createBoard();
        this.game = new Game(classicBoard, new CheckValidator(Type.KING), new CheckMateValidator(new CheckValidator(Type.KING)), Color.WHITE);
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
            Game newGame = result.getValue().get();
            if ( !newGame.getGameRuleValidator().isValid(newGame, start, end)){
                return new InvalidMove("King is checked");
            }
            if ( newGame.getGameEndValidator().isValid(newGame, start, end)) {
                return new GameOver(Adapter.getCurrentTurn(current));
            }
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
