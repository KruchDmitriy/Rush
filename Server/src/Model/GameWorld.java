package Model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class GameWorld implements IGameWorld {
    private Vector<IPlayer> players;
    private Vector<IRace> races;

    @Override
    public void waitForPlayers() {
        ServerSocket listener = new ServerSocket(777);
        while (true) {
            Socket socket = listener.accept();
            PrintWriter printWriter =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader =
                    new BufferedReader(socket.getInputStream());
            registerPlayer(new Player(bufferedReader, printWriter));
        }
    }

    @Override
    public void registerPlayer(IPlayer player) {
        players.add(player);
    }
}
