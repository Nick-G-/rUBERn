package rUBERn;

// Created by nico on 9/30/16.

public abstract class Person extends Entity implements Locatable {
    private Location currentLocation;
    private String name;
    public Location getLocation() {
        return currentLocation;
    }
}
