package rush.client.model;

import java.util.List;

public class Race implements IRace {
    Connection connection;
    List<IPlayer> players;

    public synchronized void setPlayersPositions(List<Position> positions) throws Exception {
        if (positions.size() != players.size())
            throw new Exception();
        for (int i = 0; i < positions.size(); i++) {
            players.get(i).setPosition(positions.get(i));
        }
    }

    @Override
    public void makePlayerAction(Player.Action action) {
        connection.sendAction(action);
    }
}
