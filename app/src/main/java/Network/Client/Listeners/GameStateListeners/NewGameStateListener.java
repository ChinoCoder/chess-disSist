package Network.Client.Listeners.GameStateListeners;

import Network.Client.GameClient;
import edu.austral.dissis.chess.gui.NewGameState;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import org.jetbrains.annotations.NotNull;

public class NewGameStateListener implements MessageListener<NewGameState> {

    private final GameClient gameClient;

    public NewGameStateListener(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void handleMessage(@NotNull Message<NewGameState> message) {
        gameClient.handleNewGameState(message.getPayload());
    }
}