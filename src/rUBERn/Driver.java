package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.Status.Offline;
import rUBERn.Status.Status;

import java.time.Duration;

public class Driver extends Person {
    private Car car;
    private Status status;
    private Job currentJob;
    Rubern rubern;
    public Driver(String name, Rubern rubern) {
        super(name);
        this.car = new Car();
        status = new Offline(Driver.this);
        this.rubern = rubern;

    }
    public Driver(CreditCard creditCard, Location startingPoint, String name, Car car,Rubern rubern) {
        super(creditCard, startingPoint, name);
        this.car = car;
        status = new Offline(Driver.this);
        this.rubern = rubern;
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
    public void goBusy() {
        try {
            status.goWorking();
        } catch (InvalidStatusChangeException | AlreadyInStatusException e) {
            e.printStackTrace();
        }
    }

    public boolean evaluateOffer(Journey journey, Client client){
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
        try {
            status.goOnline();
        } catch (AlreadyInStatusException e) {
            e.printStackTrace();
        }
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
    public void addToSorter(){
        rubern.addDriver(Driver.this);
    }
}
