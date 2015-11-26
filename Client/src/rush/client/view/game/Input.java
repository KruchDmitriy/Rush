package rush.client.view.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rush.client.model.IRace;
import rush.client.model.Player;

public class Input {
    IRace world;
    EventHandler<KeyEvent> keyHandler;

    public Input(IRace world) {
        this.world = world;
        keyHandler = event -> {
            if (KeyCode.LEFT == event.getCode()) {
                world.makePlayerAction(Player.Action.TURN_LEFT);
            } else
            if (KeyCode.RIGHT == event.getCode()) {
                world.makePlayerAction(Player.Action.TURN_RIGHT);
            } else
            if (KeyCode.UP == event.getCode()) {
                world.makePlayerAction(Player.Action.SPEED_UP);
            } else
            if (KeyCode.DOWN == event.getCode()) {
                world.makePlayerAction(Player.Action.SLOW_DOWN);
            }
        };
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }
}
