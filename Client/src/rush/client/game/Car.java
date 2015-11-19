package rush.client.game;

import rush.client.engine.Sprite;

public class Car extends Sprite {

    public Car() {
        // TODO: Load car image and assigned it to node
    }
    @Override
    public void update() {
        // TODO: Get data from server
        double x = 0;
        double y = 0;
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
}
