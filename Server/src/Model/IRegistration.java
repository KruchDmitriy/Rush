package Model;

import java.util.UUID;

public interface IRegistration {
    void registerPlayer(String playerName, CarModel car);
    List<RaceHandle> getListRaces();
    UUID createRace(String raceName, String mapName);
    void joinRace(UUID raceId);
}
