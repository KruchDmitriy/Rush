package rush.server.model;

import java.util.Random;
import java.util.UUID;
import java.util.Vector;

public class Race implements IRace {
    private String name;
    private UUID id;
    private Map map;
    private Integer maxPlayers;
    private Vector<Player> players;

    public Race(String name, Map.MapName mapName, Integer maxPlayers) {
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
    public void removePlayer(IPlayer player) {
        players.remove(player);
    }

    @Override
    public boolean allIsReady() {
        boolean allIsReady = true;
        for (Player p : players) {
            allIsReady = allIsReady && p.isReady();
        }
        return allIsReady;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Point movePlayer(IPlayer player, Vector2d direct_shift) {
        /*
            TODO: Check it! Dangerous. Program logic.
        */

        // Hyper parameters
        float g = 9.8f;
        float resistCoeff = 1.0f;

        Point position = player.getPosition();
        Vector2d velo = player.getVelocity();

        //float phi = Math.abs(velo.angle - direct.angle);
        float phi = direct_shift.angle;
        PointParam consistence = map.getConsistence(position);
        float mu = consistence.friction * direct_shift.length; // Improvisation

        float ax = mu * g * (float)Math.cos(phi)
                   - resistCoeff * velo.length * velo.length;
        float ay = mu * g * (float)Math.sin(phi);
        Vector2d newVelo = velo.shift(ax, ay);

        Point newPosition = null;
        if (consistence.marker == PointParam.Marker.GOOD_ROAD) {
            newPosition = position.add(newVelo);
        } else if (consistence.marker == PointParam.Marker.PLAYER) {
            newPosition = position;
        } else if (consistence.marker == PointParam.Marker.BAD_ROAD) {
            Random rand = new Random();
            newVelo = newVelo.shift(rand.nextFloat(), rand.nextFloat() / 10.0f);
            newPosition = position.add(newVelo);
        } else if (consistence.marker == PointParam.Marker.FINISH) {
            player.setFinishedRace(true);
        }
        return newPosition;
    }
}
