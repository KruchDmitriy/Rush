package Model;

import java.util.UUID;

public interface IRace {
    void addPlayer(IPlayer player);
    UUID getId();
    void playerIsReady(UUID playerId);
    void removePlayer(UUID playerId);
    void startGame();
    void update();
    void gameOver();
}
