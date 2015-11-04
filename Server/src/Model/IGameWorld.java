package Model;

import java.io.IOException;
import java.util.UUID;

public interface IGameWorld {
    void waitForPlayers() throws IOException;
    void registerPlayer(IPlayer player);
    List<RaceHandle> getListRaces();
    void addRace(IRace race);
    IRace findRace(UUID raceId);
}
