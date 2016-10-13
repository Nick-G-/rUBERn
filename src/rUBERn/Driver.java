package rUBERn;// Created by nico on 9/30/16.

public class Driver implements Locatable {
    private Car car;
    private Boolean isOnline;
    private Boolean isAvailable;

    public void goOnline() {
    }

    public Car getCar() {
        return car;
    }

    public void goOffline() {
    }

    public boolean evaluateOffer(Journey journey) {
        return false;
    }

    public void finalizeJob() {
    }

    public void idle() {
    }

    public void driveTo() {
    }

    @Override
    public Location getLocation() {
        return null;
    }
}
