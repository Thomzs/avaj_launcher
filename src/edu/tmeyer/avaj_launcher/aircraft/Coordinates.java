package edu.tmeyer.avaj_launcher.aircraft;

public class Coordinates {
    public  int longitude;
    public  int latitude;
    public  int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "{" + longitude +
                ", " + latitude +
                ", " + height +
                '}';
    }
}
