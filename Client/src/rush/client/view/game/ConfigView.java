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
    private String toExit;
    private Scene playerCreationScene;
    private Scene racesListScene;

    EventHandler<ActionEvent> registerPlayer = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String playerName = ((TextField)playerCreationScene.lookup("#playerName")).getPromptText();
            if (playerName.length() == 0)
                return;
            //userController.registerPlayer(new PlayerDescriptor(playerName));
            stage.setScene((racesListScene));
        }
    };

    EventHandler<ActionEvent> setRace = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            RaceDescriptor choosenRace = racesListView.getSelectionModel().getSelectedItem();
            //userController.chooseRace(choosenRace);

        }
    };

    EventHandler<ActionEvent> ready = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            //userController.ready();
            //user.unsubscribe(this);
            listener.returnStage(toGame);
        }
    };

    public ConfigView(String toGame, String toExit) {
        this.toGame = toGame;
        this.toExit = toExit;
        //user.subscribe(this);
        FlowPane playerCreationPane = new FlowPane();
        TextField forPlayerName = new TextField();
        forPlayerName.setId("playerName");
        Button registerPlayerButton = new Button("Register player");
        registerPlayerButton.setOnAction(registerPlayer);
        playerCreationPane.getChildren().addAll(forPlayerName, registerPlayerButton);
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

//    @Override
//    public PlayerDescriptor getPlayerDescriptor() {
//        while (!playerCreated) {}
//        return playerDescriptor;
//    }
//
//    @Override
//    public RaceDescriptor getChosenRace() {
//        while (!raceChosen) {}
//        return raceDescriptor;
//    }
//
//    @Override
//    public void waitWhenReady() {
//        while (!ready) {}
//    }
}
