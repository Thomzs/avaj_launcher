package edu.tmeyer.avaj_launcher.aircraft;

import edu.tmeyer.avaj_launcher.WeatherTower;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

public class Helicopter extends Aircraft implements Flyable {

    private final static String TYPE = "Helicopter";

    private WeatherTower weatherTower;
    private final Map<String, String> msg = Map.ofEntries(
            entry("RAIN", "Currently slicing raindrops lol"),
            entry("FOG", "Oh fog, at least one can still hear me"),
            entry("SUN", "AM A FREAKING FLYING FAN"),
            entry("SNOW", "That snow is starting to get me cold"),
            entry("LANDED", "Vertical landing, yeah I'm flexin'")
    );

    Helicopter(String name, Coordinates coordinates) {
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
        return "HELICOPTER#" + this.name + "(" + this.id + ")";
    }
}
