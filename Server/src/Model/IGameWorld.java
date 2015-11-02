package Model;

import java.util.UUID;

public interface IGameWorld {
    void waitForPlayers();
    void registerPlayer(IPlayer player);
    List<RaceHandle> getListRaces();
    void createRace(IRace race);
    IRace findRace(UUID raceId);
}
