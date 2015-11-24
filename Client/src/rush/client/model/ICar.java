package rush.client.model;

import rush.client.view.ICarView;

public interface ICar {

    String getName();

    Position getPosition();

    void setName(String name);

    void setPosition(Position position);

    void link(ICarView carView) throws Exception;
}
