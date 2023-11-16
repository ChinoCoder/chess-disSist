package Network.Server;

import Network.Server.Listeners.GameListener;
import Network.Server.Listeners.GameServerListener;
import Network.Server.Listeners.MoveListener;
import com.fasterxml.jackson.core.type.TypeReference;
import edu.austral.dissis.chess.gui.*;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.Server;
import edu.austral.ingsis.clientserver.ServerBuilder;

public class GameServer {
    private final Server server;
    private final GameEngine gameEngine;

    public GameServer(GameEngine gameEngine, ServerBuilder serverBuilder) {
        this.gameEngine = gameEngine;
        this.server = buildServer(serverBuilder);
        server.start();
    }

    public void move(Move move) {
        MoveResult result = gameEngine.applyMove(move);
        broadcastGameState(result);
    }

    public void broadcastGameState(MoveResult state) {
        if (state instanceof NewGameState) {
            server.broadcast(new Message<>("new-game-state", state));
        } else if (state instanceof GameOver) {
            server.broadcast(new Message<>("game-over", state));
        } else if (state instanceof InvalidMove) {
            server.broadcast(new Message<>("invalid-move", state));
        }
    }

    public void newGame() {
        InitialState initialState = gameEngine.init();
        server.broadcast(new Message<>("init", initialState));
    }

    public Server buildServer(ServerBuilder builder){
        return builder
                .withPort(8080)
                .withConnectionListener(new GameServerListener(this))
                .addMessageListener("move", new TypeReference<>(){}, new MoveListener(new GameListener(this)))
                .build();
    }

}
