package rush.server.model;

import java.util.EnumSet;
import java.util.Vector;

public class Map {
    public enum MapName {
        theDust("theDust"),
        aztec("aztec"),
        goldenDragon("goldenDragon");

        private String value;

        MapName(String value){
            this.value = value;
        }

        public String toString(){
            return value;
        }

        public static MapName getByValue(String value){
            for (final MapName element : EnumSet.allOf(MapName.class)) {
                if (element.toString().equals(value)) {
                    return element;
                }
            }
            return null;
        }
    }
    private MapName mapName;
    private Vector<Vector<PointParam>> consistence;

    private Vector<Vector<PointParam>> loadConsistence(MapName mapName) {
        return null;
    }

    public Map(MapName mapName) {
        this.mapName = mapName;
        consistence = loadConsistence(mapName);
    }

    public PointParam getConsistence(Point point) {
        return consistence.elementAt(point.x).elementAt(point.y);
    }
}
