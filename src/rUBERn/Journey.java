package rUBERn;

// Created by nico on 9/30/16.

public class Journey {
    private Location origin;
    private Location destination;
    private int passengers;

    public Journey(Person person) {
        this.origin = person.getCurrentLocation();
        this.destination = new Location();
        this.passengers = 1;
    }
    public Journey(Location origin, Location destination, int passengers){
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
    }

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
    public String toString() {
        return ("journey of " + String.format("%.2f", origin.distanceTo(destination)) + "m from " + origin.toString() + " to " + destination.toString());
    }
}
