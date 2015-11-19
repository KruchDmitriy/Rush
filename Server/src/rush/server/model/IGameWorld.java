package rush.server.model;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface IGameWorld {
    void waitForPlayers() throws IOException;
    void registerPlayer(IPlayer player);
    List<Race> getListRaces();
    void addRace(IRace race);
    IRace findRace(UUID raceId);
}
