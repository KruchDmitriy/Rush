package rush.client;

import javafx.application.Application;
import javafx.stage.Stage;
import rush.client.model.Connection;
import rush.client.view.IState;
import rush.client.view.IStateListener;
import rush.client.view.game.ConfigView;
import rush.client.view.game.RaceView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

public class Client extends Application
        implements IStateListener
{
    /*
        1st - Initialization;
        2nd - Configuration;
        3rd - Game

        Initialization -> Configuration
        Configuration -> Game
        Configuration -> Exit
        Game -> Configuration
        Game -> Exit
    */

    Stage mainStage;
    HashMap<String, IState> states;

    public static void main(String[] args) {
        launch(args);
    }

    private Connection createConnection(Properties communicationProperties) throws IOException{
        // TODO: Make static in Connection class ???
        String ip = communicationProperties.getProperty("ip");
        String port = communicationProperties.getProperty("port");
        Socket socket = new Socket(ip, Integer.valueOf(port));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //return new Connection(bufferedReader, printWriter);
        return null;
    }

    public void init() {
//        InputStream input = null;
//        Properties communication = null;
//        try {
//            String pathToConfig = this.getClass().getResource("config.properties").getPath();
//            input = new FileInputStream(pathToConfig);
//            communication.load(input);
//            Connection connection = createConnection(communication);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (input != null) {
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        states = new HashMap<>();
        states.put("configuration", new ConfigView("game", "exit"));
        states.put("game", new RaceView("configuration", "exit"));
    }

    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        states.get("configuration").occupyStage(mainStage);
        mainStage.show();
    }

    public void stop() {
        // TODO: Send to server that connection is over
    }

    @Override
    public void returnStage(String nextState) {
        mainStage.hide();
        mainStage.setScene(null);
        states.get(nextState).occupyStage(mainStage);
        mainStage.show();
    }
}