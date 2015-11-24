package rush.client.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public interface IInput {
    EventHandler<KeyEvent> getKeyHandler();
}
