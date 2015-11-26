package rush.client.model;

import rush.client.view.game.IPlayerView;

public interface IPlayer {

    String getName();

    void setName(String name);

    Position getPosition();

    void setPosition(Position position);

    void link(IPlayerView carView) throws Exception;
}
