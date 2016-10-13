package rUBERn;// Created by nico on 9/30/16.

public class Driver extends Person {
    private Car car;
    private Boolean isOnline;
    private Boolean isAvailable;

    public Driver(Car car){
        this.car = car;
        this.isOnline = false;
        this.isAvailable = false;
    }
    public void goOnline() {
        isOnline = true;
    }

    public Car getCar() {
        return car;
    }

    public void goOffline() {
        isOnline = false;
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
}
