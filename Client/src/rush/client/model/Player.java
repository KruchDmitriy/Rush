package rush.client.model;

import rush.client.view.ICarView;

public class Player implements IPlayer {
    public enum Action {
        TURN_LEFT,
        TURN_RIGHT,
        SPEED_UP,
        SLOW_DOWN
    }
    public enum CarModel {
        black("black"),
        blue("blue"),
        green("green"),
        cyan("cyan"),
        red("red"),
        magenta("magenta"),
        yellow("yellow"),
        white("white");

        private String value;

        CarModel(String value){
            this.value = value;
        }

        public String toString(){
            return value;
        }

        public static CarModel getByValue(String value){
            for (final CarModel element : EnumSet.allOf(CarModel.class)) {
                if (element.toString().equals(value)) {
                    return element;
                }
            }
            return null;
        }
    }

    private String name;
    private Position position;
    private CarModel car;

    public IPlayerView playerView;

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
        playerView.positionChange();
    }

    @Override
    public void link(IPlayerView playerView) {
        if (playerView != null)
            throw new NullPointerException("Invalid parameter");
        this.playerView = playerView;
    }
}
