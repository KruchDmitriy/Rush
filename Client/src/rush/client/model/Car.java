package rush.client.model;

import rush.client.view.ICarView;

/**
 * Created by anton on 11/24/2015.
 */
public class Car implements ICar {
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
