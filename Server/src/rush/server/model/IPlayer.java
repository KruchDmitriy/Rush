package rush.server.model;

import java.util.UUID;

public interface IPlayer {
    UUID getId();
    void setStartPosition(Point pos, float angle);
    void changeVelocity(Vector2d velocity);
    void setPosition(Point pos);
    void changeState(boolean isReady);
    boolean isReady();
    Point getPosition();
    Vector2d getVelocity();
    boolean isFinishedRace();
    void setFinishedRace(boolean finishedRace);
}
