package edu.tmeyer.avaj_launcher.aircraft;

import edu.tmeyer.avaj_launcher.WeatherTower;

import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

public class JetPlane extends Aircraft implements Flyable {

    private final static String TYPE = "JetPlane";

    private WeatherTower weatherTower;
    private final Map<String, String> msg = Map.ofEntries(
            entry("RAIN", "Rain? lmao we'll see *thrust 110%*"),
            entry("FOG", "Well, glad I have my radar working in this fog"),
            entry("SUN", "TRAIIILS"),
            entry("SNOW", "I'm about to become Sliderman with all that snow"),
            entry("LANDED", "CAUTION TERRAIN, TOO LOW... *PAF*")
    );

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String newWeather = this.updateCoordinates(weatherTower.getWeather(this.coordinates), TYPE);
        System.out.println(this + ": " + msg.get(newWeather) + " | new coordinates: " + this.coordinates);
        if (Objects.equals(newWeather, "LANDED")) {
            this.weatherTower.unRegister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "JETPLANE#" + this.name + "(" + this.id + ")";
    }
}