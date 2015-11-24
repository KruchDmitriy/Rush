package rush.client.model;

import java.util.List;

/**
 * Created by anton on 11/24/2015.
 */
public class World implements IWorld{
    Connection connection;
    List<ICar> cars;

    public synchronized void setPlayersPositions(List<Position> positions) throws Exception {
        if (positions.size() != cars.size())
            throw new Exception();
        for (int i = 0; i < positions.size(); i++) {
            cars.get(i).setPosition(positions.get(i));
        }
    }

    @Override
    public void makePlayerAction(PlayerAction action) {
        connection.sendAction(action);
    }
}
