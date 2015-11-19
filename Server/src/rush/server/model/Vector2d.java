package rush.server.model;

public class Vector2d {
    public float length;
    public float angle;

    public Vector2d(float length, float angle) {
        this.length = length;
        this.angle = angle;
    }

    public Vector2d shift(float shiftx, float shifty) {
        float new_length = (float)Math.sqrt(
                (length + shiftx) * (length + shiftx) + shifty * shifty);
        float new_angle = (float)Math.acos(shifty / new_length);
        return new Vector2d(new_length, new_angle);
    }
}
