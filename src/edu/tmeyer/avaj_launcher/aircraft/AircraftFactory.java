package edu.tmeyer.avaj_launcher.aircraft;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {

        if (longitude < 0 || latitude < 0 || height < 0) throw new Exception("Error: Please provide non negative coordinates");

        if (height > 100) height = 100;

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        return switch (type.toLowerCase()) {
            case "helicopter" -> new Helicopter(name, coordinates);
            case "jetplane" -> new JetPlane(name, coordinates);
            case "balloon", "baloon" -> new Balloon(name, coordinates);
            default -> throw new Exception("ERROR: No aicraft known as: " + "'" + type + "'");
        };
    }
}
