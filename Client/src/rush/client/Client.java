package rush.client;

import javafx.application.Application;
import javafx.stage.Stage;
import rush.client.model.Connection;
import rush.client.view.engine.World;
import rush.client.view.game.Rush;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client extends Application
{
    public World world = new Rush();

    public static void main(String[] args) {
        launch(args);
    }

    private Connection createConnection(Properties communicationProperties) throws IOException{
        String ip = communicationProperties.getProperty("ip");
        String port = communicationProperties.getProperty("port");
        Socket socket = new Socket(ip, Integer.valueOf(port));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //return new Connection(bufferedReader, printWriter);
        return null;
    }

    public void init() {
        InputStream input = null;
        Properties communication = null;
        try {
            String pathToConfig = this.getClass().getResource("config.properties").getPath();
            input = new FileInputStream(pathToConfig);
            communication.load(input);
            Connection connection = createConnection(communication);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start(Stage stage)  {
        world.initialize(stage);
        world.beginGameLoop();
        stage.show();
    }

    public void stop() {
        // TODO: Send to server that connection is over
    }
}