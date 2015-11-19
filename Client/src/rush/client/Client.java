package rush.client;

import javafx.application.Application;
import javafx.stage.Stage;
import rush.client.engine.World;
import rush.client.game.Rush;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Client extends Application
{
    public static World world = new Rush();

    public static void main(String[] args) {
        launch(args);
    }

    public void init() {
        InputStream input = null;
        Properties communication = null;
        try {
            String pathToConfig = this.getClass().getResource("config.properties").getPath();
            input = new FileInputStream(pathToConfig);
            communication.load(input);
            System.out.println(communication.getProperty("ip"));
            System.out.println(communication.getProperty("host"));
            // TODO: Use config file to create access with server
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