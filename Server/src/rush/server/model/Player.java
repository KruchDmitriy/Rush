package rush.server.model;

import java.util.EnumSet;
import java.util.UUID;

public class Player implements IPlayer {
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
    private UUID id;
    private CarModel car;
    private boolean readyForGame;
    private boolean finishedRace;
    private Point pos;
    private Vector2d velocity;

    public Player(String name, CarModel car) {
        id = UUID.randomUUID();
        this.name = name;
        this.car = car;
        readyForGame = false;
        finishedRace = false;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setStartPosition(Point pos, float angle) {
        this.pos = pos;
        velocity.angle = angle;
        velocity.length = 0.0f;
    }

    @Override
    public void changeState(boolean isReady) {
        this.readyForGame = isReady;
    }

    @Override
    public boolean isReady() {
        return readyForGame;
    }

    @Override
    public void changeVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    @Override
    public void setPosition(Point pos) {
        this.pos = pos;
    }

    @Override
    public Point getPosition() {
        return pos;
    }

    @Override
    public Vector2d getVelocity() {
        return velocity;
    }

    @Override
    public boolean isFinishedRace() {
        return finishedRace;
    }

    @Override
    public void setFinishedRace(boolean finishedRace) {
        this.finishedRace = finishedRace;
    }
}
