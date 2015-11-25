package rush.client.model;

import rush.client.view.ICarView;

public class Player implements IPlayer {
    public enum Action {
        TURN_LEFT,
        TURN_RIGHT,
        SPEED_UP,
        SLOW_DOWN
    }

    private String name;
    private Position position;
    public ICarView carView;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        carView.positionChange();
    }

    @Override
    public void link(ICarView carView) throws Exception {
        if (carView != null)
            throw new Exception();
        this.carView = carView;
    }
}
