package rush.client.view.game;

import rush.client.model.IPlayer;
import rush.client.view.IPlayerView;
import rush.client.view.engine.Sprite;

public class PlayerView extends Sprite implements IPlayerView {

    public PlayerView() {
        // TODO: Load car image and assigned it to node
    }

    @Override
    public void playerChanged(IPlayer player) {
        node.setTranslateX(player.getPosition().x);
        node.setTranslateY(player.getPosition().y);
        // TODO: force redraw?
    }
}
