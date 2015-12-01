package rush.client.view.game;

import rush.client.model.Player;

/**
 * Created by anton on 12/1/2015.
 */
public class PlayerDescriptor {
    String name;
    Player.CarModel model;

    public PlayerDescriptor(String playerName) {
        name = playerName;
    }
}
