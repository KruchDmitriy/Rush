package rush.server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class GameWorld implements IGameWorld {
    private Vector<Player> players;
    private Vector<Race> races;

    @Override
    public void waitForPlayers() throws IOException {
        ServerSocket listener = new ServerSocket(777);
        while (true) {
            Socket socket;
            PrintWriter printWriter = null;
            BufferedReader bufferedReader = null;
            try {
                socket = listener.accept();
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Connection c = new Connection(bufferedReader, printWriter, this);
        }
    }

    @Override
    public void registerPlayer(IPlayer player) {
        players.add((Player)player);
    }

    @Override
    public void addRace(IRace race) {
        races.add((Race)race);
    }

    @Override
    public IRace findRace(UUID raceId) {
        Race race = null;
        for (Race r : races) {
            if (r.getId() == raceId) {
                race = r;
                break;
            }
        }
        return race;
    }

    @Override
    public List<Race> getListRaces() {
        // TODO: Is it safe?!
        return races;
    }
}
