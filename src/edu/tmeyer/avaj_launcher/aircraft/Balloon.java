package edu.tmeyer.avaj_launcher.aircraft;

import edu.tmeyer.avaj_launcher.WeatherTower;

import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

public class Balloon extends Aircraft implements Flyable {

    private final static String TYPE = "Balloon";

    private WeatherTower weatherTower;
    private final Map<String, String> msg = Map.ofEntries(
            entry("RAIN", "AM SINGIN' IN THA RAIN"),
            entry("FOG", "Fog. Am blind. No see. SCARED"),
            entry("SUN", "Too hot, please get me higher, need some air"),
            entry("SNOW", "Sheesh, snow's only cool in picture"),
            entry("LANDED", "DRY LAND DEAR! OH YEAH")
    );


    Balloon(String name, Coordinates coordinates) {
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
        return "BALLOON#" + this.name + "(" + this.id + ")";
    }
}