package rush.server.model;

public class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point add(Vector2d v) {
        int dx = (int)(v.length * Math.cos(v.angle));
        int dy = (int)(v.length * Math.sin(v.angle));
        return new Point(x + dx, y + dy);
    }
}
