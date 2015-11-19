package rush.server.model;

import java.util.UUID;

public interface IRace {
    void addPlayer(IPlayer player);
    UUID getId();
    void removePlayer(IPlayer player);
    boolean allIsReady();
    Point movePlayer(IPlayer player, Vector2d shift);
}
