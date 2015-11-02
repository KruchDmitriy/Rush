package Model;

import java.util.UUID;
import java.util.Vector;

public class Race implements IRace {
    private String name;
    private UUID id;
    private Map map;
    private Integer maxPlayers;
    private Vector<Player> players;

    public Race(String name, MapName mapName, Integer maxPlayers) {
        this.name = name;
        this.map = new Map(mapName);
        this.maxPlayers = maxPlayers;
        players = new Vector<>(maxPlayers);
        this.id = UUID.randomUUID();
    }

    @Override
    public void addPlayer(IPlayer player) {
        assert players.size() < maxPlayers;
        players.add((Player)player);
    }

    @Override
    public void removePlayer(UUID playerId) {
        for (Player p : players) {
            if (p.getId() == playerId) {
                players.remove(p);
                break;
            }
        }
    }

    @Override
    public UUID getId() {
        return id;
    }
}
