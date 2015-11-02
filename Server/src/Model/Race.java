package Model;

import java.util.UUID;
import java.util.Vector;

public class Race implements IRace {
    private String name;
    private UUID id;
    private Map map;
    private Integer maxPlayers;
    private Vector<IPlayer> players;

    public Race(String name, MapName mapName, Integer maxPlayers) {
        this.name = name;
        this.map = new Map(mapName);
        this.maxPlayers = maxPlayers;
    }
}
