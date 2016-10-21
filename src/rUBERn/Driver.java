package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;
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

    public void goOnline() throws AlreadyInStatusException {
        status.goOnline();
    }
    public void goOffline() throws AlreadyInStatusException, InvalidStatusChangeException {
        status.goOffline();
    }
    public void goBusy() throws AlreadyInStatusException, InvalidStatusChangeException {
        status.goWorking();
    }

    public boolean evaluateOffer(Journey journey, Client client) throws AlreadyInStatusException, InvalidStatusChangeException {
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

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public Car getCar() {
        return car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status s){
        status = s;
    }
}
