package rush.client.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rush.client.model.IRace;
import rush.client.model.Player;

public class Input implements IInput{
    IRace world;
    EventHandler<KeyEvent> keyHandler;

    public Input(IRace world) {
        this.world = world;
        keyHandler = event -> {
            if (KeyCode.LEFT == event.getCode()) {
                world.makePlayerAction(Player.Action.TURN_LEFT);
                return;
            } else
            if (KeyCode.RIGHT == event.getCode()) {
                world.makePlayerAction(Player.Action.TURN_RIGHT);
                return;
            } else
            if (KeyCode.UP == event.getCode()) {
                world.makePlayerAction(Player.Action.SPEED_UP);
                return;
            } else
            if (KeyCode.DOWN == event.getCode()) {
                world.makePlayerAction(Player.Action.SLOW_DOWN);
                return;
            }
        };
    }

    @Override
    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }
}
