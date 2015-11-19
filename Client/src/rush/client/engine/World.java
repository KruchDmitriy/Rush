package rush.client.engine;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class World {
    private Group sceneNodes;
    private Scene gameSurface;
    private static Timeline gameLoop;
    private final int framesPerSecond;
    private final String windowTitle;

    private final SpriteManager spriteManager = new SpriteManager();
    private final SoundManager soundManager = new SoundManager(3);

    public World(final int fps, final String title) {
        framesPerSecond = fps;
        windowTitle = title;
        buildAndSetGameLoop();
    }

    protected final void buildAndSetGameLoop() {
        final Duration oneFrameAmt = Duration.millis(1000/getFramesPerSecond());
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt,this::frameProcessor);
        Timeline timeline = new Timeline(getFramesPerSecond(), oneFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        setGameLoop(timeline);
    }

    private void frameProcessor(Event e)
    {
        updateSprites();
        cleanupSprites();
    }

    public abstract void initialize(final Stage primaryStage);

    public void beginGameLoop() {
        getGameLoop().play();
    }

    protected void updateSprites() {
        for (Sprite sprite : spriteManager.getAllSprites()){
            handleUpdate(sprite);
        }
    }

    protected void handleUpdate(Sprite sprite) {
    }


    protected void cleanupSprites() {
        spriteManager.cleanupSprites();
    }

    protected int getFramesPerSecond() {
        return framesPerSecond;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    protected static Timeline getGameLoop() {
        return gameLoop;
    }

    protected static void setGameLoop(Timeline gameLoop) {
        World.gameLoop = gameLoop;
    }

    protected SpriteManager getSpriteManager() {
        return spriteManager;
    }

    public Scene getGameSurface() {
        return gameSurface;
    }

    protected void setGameSurface(Scene gameSurface) {
        this.gameSurface = gameSurface;
    }

    public Group getSceneNodes() {
        return sceneNodes;
    }

    protected void setSceneNodes(Group sceneNodes) {
        this.sceneNodes = sceneNodes;
    }

    protected SoundManager getSoundManager() {
        return soundManager;
    }

    public void shutdown() {
        getGameLoop().stop();
        getSoundManager().shutdown();
    }
}