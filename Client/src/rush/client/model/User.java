package rush.client.model;

import java.util.List;

public class User implements IUser {
    private enum Action {
        REGISTER_PLAYER,
        CREATE_RACE,
        JOIN_RACE
    }

    private Connection connection;
    private Player player;
    private Race ownRace;
    private List<Race> races;

    private final IConfigView configView;

    public User(Connection connection) {
        if (connection == null)
            throw new NullPointerException("Invalid parameter");
        this.connection = connection;
    }

    public PlayerHandle getPlayer() {
        return player;
    }

    public void setPlayer(PlayerHandle player) {
        if (player == null)
            throw new NullPointerException("Invalid parameter");

        // TODO: Try catch or another thing?
        connection.register(player);

        this.player = player;
        notify(Action.REGISTER_PLAYER);
    }

    public RaceHandle getRace() {
        return ownRace;
    }

    public void setRace(RaceHandle race) {
        if (race == null)
            throw new NullPointerException("Invalid parameter");
        this.race = race;
        notify(Action.CREATE_RACE);
    }

    public List<RaceHandle> getListRaces() {
        return races;
    }

    private void notify(Action action) {
        if (action == null)
            throw new NullPointerException("Invalid parameter");
        switch (action) {
            case REGISTER_PLAYER: break;
            case CREATE_RACE: break;
            case JOIN_RACE: break;
        }
        configView.
    }
}
