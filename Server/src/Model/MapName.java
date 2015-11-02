package Model;

import java.util.EnumSet;

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
