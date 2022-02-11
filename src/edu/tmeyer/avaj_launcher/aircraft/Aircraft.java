package edu.tmeyer.avaj_launcher.aircraft;

import java.util.HashMap;
import java.util.Map;

public class Aircraft {

    protected         long        id;
    protected         String      name;
    protected         Coordinates coordinates;
    private   static  long        idCounter = 0;

    private final Map<String, int[]> sun = Map.of(
            "JetPlane", new int[] {0, 10, 2},
            "Helicopter", new int[] {10, 0, 2},
            "Balloon", new int[] {2, 0, 4}
    );

    private final Map<String, int[]> rain = Map.of(
            "JetPlane", new int[] {0, 5, 0},
            "Helicopter", new int[] {5, 0, 0},
            "Balloon", new int[] {0, 0, -5}
    );

    private final Map<String, int[]> fog = Map.of(
            "JetPlane", new int[] {0, 1, 0},
            "Helicopter", new int[] {1, 0, 0},
            "Balloon", new int[] {0, 0, -3}
    );

    private final Map<String, int[]> snow = Map.of(
            "JetPlane", new int[] {0, 0, -7},
            "Helicopter", new int[] {0, 0, -12},
            "Balloon", new int[] {0, 0, -15}
    );


    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return (idCounter++);
    }

    protected String updateCoordinates(String weather, String type) {
        int newHeight = 0;
        int currentHeight = coordinates.getHeight();
        int[] changes;

        switch (weather) {
            case "SUN":
                changes = sun.get(type);
                break;
            case "RAIN":
                changes = rain.get(type);
                break;
            case "FOG":
                changes = fog.get(type);
                break;
            case "SNOW":
                changes = snow.get(type);
                break;
            default:
                return weather;
        }

        newHeight = currentHeight + changes[2];
        coordinates = new Coordinates(
                coordinates.getLongitude() + changes[0],
                coordinates.getLongitude() + changes[1],
                newHeight > 100 ? 100 : newHeight                   //Math.min(100, newHeight);
        );
        return newHeight > 0 ? weather : "LANDED";
    }
}
