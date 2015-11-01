package Model;

import java.util.UUID;

public interface IRace {
    void playerIsReady(UUID playerId);
    void leaveRace(UUID playerId);
    void startGame();
    void update();
    void gameOver();
}
