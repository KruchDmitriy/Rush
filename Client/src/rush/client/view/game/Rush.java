package rush.client.view.game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import rush.client.view.engine.Sprite;
import rush.client.view.engine.World;

import java.util.List;

public class Rush extends World
{
    public Rush() {
        super(59, "Rush");
    }

    @Override
    public void initialize(final Stage primaryStage) {
        primaryStage.setTitle("Rush");

        // Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), 800, 600));
        getGameSurface().setFill(Color.BLACK);
        primaryStage.setScene(getGameSurface());

        // Setup Game input
        setupInput(primaryStage);

        // Get all sprites from server
        List<Sprite> serverSprites = getServerSprites();

        for (Sprite sprite : serverSprites) {
            getSpriteManager().addSprites(sprite);
            getSceneNodes().getChildren().add(sprite.node);
        }

    }

    private void setupInput(Stage primaryStage) {
        // Setup input callbacks
        EventHandler changeWeapons = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (KeyCode.LEFT == event.getCode()) {
                    // send data to server
                    return;
                } else
                if (KeyCode.RIGHT == event.getCode()) {
                    // send data to server
                    return;
                } else
                if (KeyCode.UP == event.getCode()) {
                    // send data to server
                    return;
                } else
                if (KeyCode.DOWN == event.getCode()) {
                    // send data to server
                    return;
                }
            }
        };
        primaryStage.getScene().setOnKeyPressed(changeWeapons);
    }

    List<Sprite> getServerSprites() {
        return null;
    }
}