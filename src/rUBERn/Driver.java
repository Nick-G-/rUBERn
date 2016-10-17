package rUBERn;// Created by nico on 9/30/16.

import java.time.Duration;

public class Driver extends Person {
    private Car car;
    private Boolean isOnline;
    private Boolean isAvailable;
    private Job currentJob;

    public Driver(String name) {
        super(name);
        this.car = new Car();
    }
    public Driver(CreditCard creditCard, Location startingPoint, String name, Car car) {
        super(creditCard, startingPoint, name);
        this.car = car;
    }

    public Driver(String name, Location startingPoint) {
        super(name, startingPoint);
    }

    public void goOnline() {
        isOnline = true;
    }
    public void goOffline() {
        isOnline = false;
    }

    public boolean evaluateOffer(Journey journey) {
        return true;
    }

    public void finalizeJob() {
    }

    public void idle() {
    }
    public void driveTo(Location destination) {

    }

    public void assignJob(Job job) {
        this.currentJob = job;
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public Car getCar() {
        return car;
    }
}
