package Model;

import java.util.EnumSet;

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
