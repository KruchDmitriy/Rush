package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class Player implements IPlayer {
    private GameWorld gameWorld;
    private Race race;

    private BufferedReader br;
    private PrintWriter pw;
    private Thread thread;

    private String name;
    private UUID id;
    private CarModel car;

    public Player(BufferedReader br, PrintWriter pw) {
        this.br = br;
        this.pw = pw;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // Register player
        boolean receiveMsg = false;
        while (!receiveMsg) {
            String message = null;
            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (message != null) {
                if (message.startsWith("registerPlayer")) {
                    String[] data = message.split(" ");
                    assert data.length == 3;
                    name = data[1];
                    car = CarModel.valueOf(data[2]);
                    receiveMsg = true;
                }
            }
        }

        // Join or create race
        receiveMsg = false;
        while (!receiveMsg) {
            String message = null;
            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (message != null) {
                if (message.startsWith("createRace")) {
                    String[] data = message.split(" ");
                    assert data.length == 3;

                    receiveMsg = true;
                }
            }
        }
    }
}
