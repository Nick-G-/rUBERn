package rUBERn;// Created by nico on 9/30/16.

import java.time.Duration;

public class Driver extends Person {
    private Car car;
    private Boolean isOnline = false;
    private Boolean isAvailable = false;
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
        isAvailable = true;
    }
    public void goOffline() {
        isOnline = false;
        isAvailable = false;
    }
    public void goBusy(){
        isAvailable = false;
    }

    public boolean evaluateOffer(Journey journey) {
        goBusy();
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
        driveTo(job.getJourney().getDestination());
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public Car getCar() {
        return car;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}
