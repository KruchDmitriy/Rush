package rush.client.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rush.client.model.IWorld;
import rush.client.model.PlayerAction;

public class Input implements IInput{
    IWorld world;
    EventHandler<KeyEvent> keyHandler;

    public Input(IWorld world) {
        this.world = world;
        keyHandler = event -> {
            if (KeyCode.LEFT == event.getCode()) {
                world.makePlayerAction(PlayerAction.TURN_LEFT);
                return;
            } else
            if (KeyCode.RIGHT == event.getCode()) {
                world.makePlayerAction(PlayerAction.TURN_RIGHT);
                return;
            } else
            if (KeyCode.UP == event.getCode()) {
                world.makePlayerAction(PlayerAction.SPEED_UP);
                return;
            } else
            if (KeyCode.DOWN == event.getCode()) {
                world.makePlayerAction(PlayerAction.SPEED_DOWN);
                return;
            }
        };
    }

    @Override
    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }
}
