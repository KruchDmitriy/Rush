package rush.client.view.game;

import javafx.stage.Stage;
import rush.client.view.IRaceView;
import rush.client.view.IState;
import rush.client.view.engine.World;

public class RaceView extends World implements IRaceView, IState {

    public RaceView(String configuration, String exit) {
        super(59, "rush");
    }

    @Override
    public void occupyStage(Stage stage) {
        stage.setScene(null);
    }

    @Override
    public void initialize(Stage primaryStage) {

    }
}
