package rush.client.model;

import rush.client.view.game.IPlayerView;

public class Player implements IPlayer {
    public IPlayerView carView;
    private String name;
    private Position position;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        carView.positionChange();
    }

    @Override
    public void link(IPlayerView carView) throws Exception {
        if (carView == null)
            throw new Exception();
        this.carView = carView;
    }

    public enum Action {
        TURN_LEFT,
        TURN_RIGHT,
        SPEED_UP,
        SLOW_DOWN
    }
}
