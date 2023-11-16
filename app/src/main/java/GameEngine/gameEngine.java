package GameEngine;

import Games.Checkers.Factories.ClassicCheckersFactory;
import Games.Checkers.Factories.CustomCheckersFactory;
import Games.Checkers.Helpers.CheckersHelper;
import Games.Checkers.Validators.NoMorePiecesValidator;
import Games.Checkers.Validators.NoPossibleMovesValidator;
import Games.Chess.Factories.ClassicChessFactory;
import Games.Chess.Factories.CustomChessFactory;
import Games.Chess.Helpers.ChessHelper;
import Games.Chess.RuleValidators.CheckMateValidator;
import Games.Chess.RuleValidators.CheckValidator;
import Games.Chess.Type;
import Games.Commons.*;
import Games.Commons.Helpers.Helper;
import Games.Commons.Validators.GameRuleOrValidator;
import Games.Commons.Validators.GameRuleValidator;
import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class gameEngine implements GameEngine {
    private Game game;
    private Helper helper;

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Game current = this.game;
        Square[] ToFrom = Adapter.convertMove(move);
        Square start = ToFrom[0];
        Square end = ToFrom[1];
        Result<Game, Boolean> result = current.move(start, end);

        if (result.getError()) {
            return new InvalidMove("Invalid Move");
        } else {
            Game newGame = this.helper.help(result.getValue().get(), start, end);
            if (!newGame.getGameRuleValidator().isValid(newGame, start, end)) {
                return new InvalidMove("Move breaks rules");
            }
            if (newGame.getGameEndValidator().isValid(newGame, start, end)) {
                return new GameOver(Adapter.getCurrentTurn(current));
            }
            this.game = newGame;
            return new NewGameState(Adapter.getCurrentPieces(this.game.getCurrentTurn()), Adapter.getCurrentTurn(this.game));
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        if (game == null) {
            System.out.println("Please select the game you want to play");
            System.out.println("1. Classic Chess");
            System.out.println("2. Classic Checkers");
            System.out.println("3. Custom Chess");
            System.out.println("4. Custom Checkers");
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int n = reader.nextInt();
            if (n == 1) {
                Board classicBoard = ClassicChessFactory.createBoard();
                this.game = new Game(classicBoard, new CheckValidator(Type.KING), new CheckMateValidator(new CheckValidator(Type.KING)), Color.WHITE);
                this.helper = new ChessHelper();
            } else if (n == 2) {
                Board classicBoard = ClassicCheckersFactory.createBoard();
                this.game = new Game(classicBoard, new CheckValidator(Type.BISHOP), new GameRuleOrValidator(new GameRuleValidator[]{new NoMorePiecesValidator(), new NoPossibleMovesValidator()}), Color.BLACK);
                this.helper = new CheckersHelper();
            } else if (n == 3) {
                Board classicBoard = CustomChessFactory.createBoard();
                this.game = new Game(classicBoard, new CheckValidator(Type.KING), new CheckMateValidator(new CheckValidator(Type.KING)), Color.WHITE);
                this.helper = new ChessHelper();
            } else if (n == 4) {
                Board classicBoard = CustomCheckersFactory.createBoard();
                this.game = new Game(classicBoard, new CheckValidator(Type.BISHOP), new GameRuleOrValidator(new GameRuleValidator[]{new NoMorePiecesValidator(), new NoPossibleMovesValidator()}), Color.BLACK);
                this.helper = new CheckersHelper();
            } else {
                System.out.println("Invalid input");
                return init();
            }
        }
        return new InitialState(Adapter.getBoardSize(this.game.getCurrentTurn()), Adapter.getCurrentPieces(this.game.getCurrentTurn()), Adapter.getCurrentTurn(this.game));
    }
}
