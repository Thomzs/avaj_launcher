package edu.tmeyer.avaj_launcher;

import edu.tmeyer.avaj_launcher.aircraft.AircraftFactory;

import java.io.BufferedReader;
import java.io.FileReader;

public class Simulator {

    private String          file;
    private BufferedReader  br;
    private int             cycles;

    private WeatherTower    tower;

    public Simulator(String file) {
        this.file = file;
    }

    void initSimulator() throws Exception {
        String[] info;
        String line;

        br = new BufferedReader(new FileReader(file));
        line = br.readLine();
        info = line.split("\\s+");
        if (info.length != 1) throw new Exception("First line must have one and only one parameter");
        cycles = Integer.parseInt(info[0]);

        int count = 1;
        tower = new WeatherTower();
        while ((line = br.readLine()) != null) {
            count++;
            info = line.split("\\s+");
            if (info.length < 5) throw new Exception("Seems like a parameter is missing line " + count);
            else if (info.length > 5) throw new Exception("Seems like there is too much information line " + count);
            AircraftFactory.newAircraft(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]))
                    .registerTower(tower);
        }

    }

    public void run() throws Exception {
        int i = 0;

        initSimulator();
        while (i++ < cycles) {
            System.out.println("CYLE: " + i);
            tower.changeWeather();
        }
    }
}
