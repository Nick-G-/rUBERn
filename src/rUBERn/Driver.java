package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Status.Status;

import java.time.Duration;

public class Driver extends Person {
    private Car car;
    private Status status;
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
    }
    public void goOffline() {
    }
    public void goBusy(){
    }

    public boolean evaluateOffer(Journey journey, Client client) {
            goBusy();
            doOffer(journey, client);
            return true;
    }
    private void doOffer(Journey journey, Client client){
        moveTo(journey.getOrigin());
        client.getOnCar(Driver.this);
        moveTo(journey.getDestination());
        client.getOffCar();
        client.arrived();
    }

    public void finalizeJob() {
    }

    public void idle() {
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public Car getCar() {
        return car;
    }

    public Boolean getOnline() {

    }

    public Boolean getAvailable() {

    }
}
