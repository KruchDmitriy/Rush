package rush.client.model;

import java.util.List;

/**
 * Created by anton on 11/24/2015.
 */
public interface IRace {
    void setPlayersPositions(List<Position> positions) throws Exception;
    void makePlayerAction(Player.Action action);
}
