package rUBERn;

// Created by nico on 9/30/16.

public abstract class Person implements Locatable {
    private Integer cardNumber;
    private Location currentLocation;
    private String name;
    public Location getLocation() {
        return currentLocation;
    }
}
