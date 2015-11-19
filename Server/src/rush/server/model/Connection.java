package rush.server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class Connection implements IConnection {
    private GameWorld gameWorld;
    private Race race;
    private Player player;
    boolean playerLeftGame;

    private BufferedReader br;
    private PrintWriter pw;
    private Thread thread;

    public Connection(BufferedReader br, PrintWriter pw, GameWorld gameWorld) {
        this.br = br;
        this.pw = pw;
        this.gameWorld = gameWorld;
        playerLeftGame = false;
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
                    String name = data[1];
                    Player.CarModel car = Player.CarModel.getByValue(data[2]);
                    player = new Player(name, car);
                    gameWorld.registerPlayer(player);
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
                    Map.MapName mapName = Map.MapName.getByValue(data[2]);
                    Integer maxPlayers = Integer.valueOf(data[3]);

                    race = new Race(name, mapName, maxPlayers);
                    gameWorld.addRace(race);
                    race.addPlayer(player);

                    receiveMsg = true;
                } else if (message. startsWith("joinRace")) {
                    String[] data = message.split(" ");
                    assert data.length == 2;

                    // TODO: check is UUID.fromString() a correct
                    race = (Race)gameWorld.findRace(UUID.fromString(data[1]));
                    assert race != null;
                    race.addPlayer(player);

                    receiveMsg = true;
                }
            }
        }
    }

    private boolean changePlayerState() {
        String message = null;
        try {
            message = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (message != null) {
            if (message.startsWith("isReady")) {
                String[] data = message.split(" ");

                assert data.length == 2;
                boolean isReady = Integer.valueOf(data[1]) == 1;
                player.changeState(isReady);
            } else if (message.startsWith("leaveRace")) {
                race.removePlayer(player);
                return false;
            }
        }
        return true;
    }

    private void startGame() {
        String message = "startGame";
        pw.write(message);
    }

    private void gameCycle() {
        float dLength = 0.1f;
        float dAngle = 0.1f;

        while (!player.isFinishedRace()) {
            String message = null;
            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Point newPosition;
            if (message != null) {
                Vector2d dir = null;
                if (message.equals("leftRotation")) {
                    dir = new Vector2d(0f, dAngle);
                } else if (message.equals("rightRotation")) {
                    dir = new Vector2d(0f, -dAngle);
                } else if (message.equals("speedUp")) {
                    dir = new Vector2d(1f + dLength, 0f);
                } else if (message.equals("slowDown")) {
                    dir = new Vector2d(1f - dLength, 0f);
                }
                newPosition = race.movePlayer(player, dir);
            } else {
                Vector2d dir = new Vector2d(1f, 0f);
                newPosition = race.movePlayer(player, dir);
            }

            pw.write("newPosition" + " "
                    + String.valueOf(newPosition.x) + " "
                    + String.valueOf(newPosition.y));
        }
    }

    private void gameOver() {
        pw.write("gameOver");
    }

    @Override
    public void run() {
        register();
        while (!playerLeftGame) {
            startRace();

            boolean leaveRace = false;
            while (!player.isReady() || !race.allIsReady()) {
                leaveRace = changePlayerState();
            }
            if (leaveRace) { continue; }

            /* TODO: How to synchronize here?!
                MUTEX!
            */
            startGame();

            gameCycle();

            gameOver();
        }
    }
}
