package edu.tmeyer.avaj_launcher.aircraft;

import edu.tmeyer.avaj_launcher.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
