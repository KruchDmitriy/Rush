package rush.client.model;

import java.util.List;

/**
 * Created by anton on 11/24/2015.
 */
public interface IWorld {
    void setPlayersPositions(List<Position> positions) throws Exception;
    void makePlayerAction(PlayerAction action);
}
