package edu.tmeyer.avaj_launcher;

import edu.tmeyer.avaj_launcher.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private final List<Flyable> observers = new ArrayList<>();
    private final List<Flyable> toRemove = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
    }

    public void unRegister(Flyable flyable) {
        toRemove.add(flyable); //Avoid concurrency issues
        System.out.println("Tower says: " + flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
        observers.removeAll(toRemove); //pushing changes
    }
}
