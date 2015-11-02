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

    public Player(BufferedReader br, PrintWriter pw, GameWorld gameWorld) {
        this.br = br;
        this.pw = pw;
        id = UUID.randomUUID();
        this.gameWorld = gameWorld;
        thread = new Thread(this);
        thread.start();
    }

    private void register() {
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
    }

    private void startRace() {
        boolean receiveMsg = false;
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

                    assert data.length == 4;
                    String name = data[1];
                    MapName mapName = MapName.valueOf(data[2]);
                    Integer maxPlayers = Integer.valueOf(data[3]);

                    Race race = new Race(name, mapName, maxPlayers);
                    gameWorld.addRace(race);
                    race.addPlayer(this);
                    this.race = race;

                    receiveMsg = true;
                } else if (message. startsWith("joinRace")) {
                    String[] data = message.split(" ");
                    assert data.length == 2;

                    // TODO: check is that a correct
                    Race race = (Race)gameWorld.findRace(UUID.fromString(data[1]));
                    assert race != null;
                    race.addPlayer(this);
                    this.race = race;

                    receiveMsg = true;
                }
            }
        }
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void run() {
        register();
        startRace();

    }
}
