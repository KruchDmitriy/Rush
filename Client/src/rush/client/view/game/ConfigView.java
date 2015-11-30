package rush.client.view.game;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import rush.client.controller.IUserController;
import rush.client.model.IUser;
import rush.client.view.IConfigView;
import rush.client.view.IState;
import rush.client.view.IStateListener;

import java.util.ArrayList;
import java.util.List;

public class ConfigView implements IConfigView, IState {
    IUser user;
    IUserController userController;
    Stage stage;
    List<RaceDescriptor> racesList;
    ListView<RaceDescriptor> racesListView;
    EventHandler<ActionEvent> createRace = event -> {
        //listener.returnStage(toGame);
    };
    private IStateListener listener;
    private String toGame;
    EventHandler<ActionEvent> setRace = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            RaceDescriptor choosenRace = racesListView.getSelectionModel().getSelectedItem();
            //userController.chooseRace(choosenRace);
            //user.unsubscribe(this);
            listener.returnStage(toGame);
        }
    };
    private String toExit;
    private Scene playerCreationScene;
    private Scene racesListScene;
    EventHandler<ActionEvent> registerPlayer = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            stage.setScene((racesListScene));
        }
    };

    public ConfigView(String toGame, String toExit) {
        this.toGame = toGame;
        this.toExit = toExit;
        //user.subscribe(this);
        FlowPane playerCreationPane = new FlowPane();
        TextField forPlayerName = new TextField();
        Button regiterPlayerButton = new Button("Register player");
        regiterPlayerButton.setOnAction(registerPlayer);
        playerCreationPane.getChildren().addAll(forPlayerName, regiterPlayerButton);
        playerCreationScene = new Scene(playerCreationPane, 640, 480);

        FlowPane racesListPane = new FlowPane();
        racesListView = new ListView<>();
        //racesList = user.getListOfRaces();
        racesList = new ArrayList<RaceDescriptor>();
        racesListView.setItems(FXCollections.observableArrayList(racesList));

        Button createRaceButton = new Button("Create New Race");
        createRaceButton.setOnAction(createRace);

        Button setRaceButton = new Button("Start Race");
        setRaceButton.setOnAction(setRace);

        racesListPane.getChildren().addAll(racesListView, createRaceButton, setRaceButton);
        racesListScene = new Scene(racesListPane, 640, 480);
    }

    @Override
    public void occupyStage(Stage stage) {
        this.stage = stage;
        stage.setScene(playerCreationScene);
    }

    @Override
    public void listOfRacesChanged() {
        //racesList = user.getListOfRaces();
        racesListView.setItems(FXCollections.observableArrayList(racesList));
    }
}
