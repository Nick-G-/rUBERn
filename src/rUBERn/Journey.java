package rUBERn;

// Created by nico on 9/30/16.

public class Journey {
    private Location origin;
    private Location destination;
    private int passengers;

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public int getPassengers() {
        return passengers;
    }
    public double getDistance(){
        return origin.distanceTo(destination);
    }
}
