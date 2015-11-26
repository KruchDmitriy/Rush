package rush.client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Connection implements Runnable {
    private IRace race;
    private IUser user;

    private BufferedReader br;
    private PrintWriter pw;
    private Thread thread;

    private boolean gameOver;

    public Connection(BufferedReader br, PrintWriter pw, IRace race) {
        this.br = br;
        this.pw = pw;
        this.race = race;
        thread = new Thread(this);
    }

    private void register() {

    }

    private void startRace() {
    }

    private boolean changePlayerState() {
        return true;
    }

    private void startGame() {
        thread.start();
    }

    public void sendAction(Player.Action action) {

    }

    private void gameCycle() {
        while (true) {
            try {
                String initStr = br.readLine();
                if (initStr.equals("gameOver"))
                    return;
                int playersNum = Integer.valueOf(initStr);
                List<Position> positions = new ArrayList<>();
                for (int i = 0; i < playersNum; i++) {
                    String currentPos = br.readLine();
                    String[] splitPos = currentPos.split(" ");
                    float x = Float.valueOf(splitPos[0]);
                    float y = Float.valueOf(splitPos[1]);
                    positions.add(new Position(x,y));
                }
                race.setPlayersPositions(positions);
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        gameCycle();
    }
}
