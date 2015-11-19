package rush.server.model;

public class PointParam {
    public float friction;
    public enum Marker { GOOD_ROAD, PLAYER, BAD_ROAD, FINISH }
    public Marker marker;

    public PointParam(float friction, Marker marker) {
        this.friction = friction;
        this.marker = marker;
    }
}
