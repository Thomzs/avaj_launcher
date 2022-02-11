package edu.tmeyer.avaj_launcher;

import edu.tmeyer.avaj_launcher.aircraft.Coordinates;

public class WeatherProvider {

    static WeatherProvider weatherProvider = null;
    static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    WeatherProvider() {
    }

    static public WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider =  new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int value = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[value % 4];
    }

}
