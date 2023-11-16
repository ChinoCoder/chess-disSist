package Network.Client.Listeners.GameStateListeners;

import Network.Client.GameClient;
import edu.austral.dissis.chess.gui.InitialState;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import org.jetbrains.annotations.NotNull;

public class InitStateListener implements MessageListener<InitialState> {
    private final GameClient gameClient;

    public InitStateListener(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void handleMessage(@NotNull Message<InitialState> message) {
        gameClient.handleInitialState(message.getPayload());
    }
}