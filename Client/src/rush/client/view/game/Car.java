package rush.client.view.game;

import rush.client.model.IPlayer;
import rush.client.view.ICarView;
import rush.client.view.engine.Sprite;

public class Car extends Sprite implements ICarView {
    IPlayer player;
    public Car() {
        // TODO: Load car image and assigned it to node
    }

    @Override
    public void positionChange() {
        node.setTranslateX(player.getPosition().x);
        node.setTranslateY(player.getPosition().y);
    }

    @Override
    public void update() {
        // TODO: Get data from server

        double x = 0;
        double y = 0;

    }
}
