package rUBERn;// Created by nico on 9/30/16.

import javafx.geometry.Point2D;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.GUI.RequestPopup;
import rUBERn.Status.Offline;
import rUBERn.Status.Status;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class Driver extends Person {
    private Car car;
    private Status status;
    private Job currentJob;
    private Rubern rubern;

    public Driver(String name, Rubern rubern) {
        super(name);
        this.car = new Car();
        status = new Offline(this);
        this.rubern = rubern;

    }
    public Driver(CreditCard creditCard, Location startingPoint, String name, Car car,Rubern rubern) {
        super(creditCard, startingPoint, name);
        this.car = car;
        status = new Offline(Driver.this);
        this.rubern = rubern;
    }

    public Driver(String name, Location startingPoint, Rubern rubern) {
        super(name, startingPoint);
        this.car = new Car();
        status = new Offline(this);
        this.rubern = rubern;
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
        if (new RequestPopup(journey, client).getAnswer()) {
            goBusy();
            return true;
        }
        return false;
    }


    public void work(int delta) {

        if (!currentJob.isFinished()) {
            Location pickup = currentJob.getJourney().getOrigin();
            Location destination = currentJob.getJourney().getDestination();
            float moveSpeed = (float) car.getSpeed() * delta / 100;
            currentLocation.moveDistanceInAngle(moveSpeed, currentLocation.angleTo(currentDestination));

            if (currentLocation.isInRangeOf(pickup, 2)) {
                currentJob.getClient().getOnCar(this);
                currentDestination = destination;
            }
            if (currentLocation.isInRangeOf(destination,1) ){
                finalizeJob();
            }
        }
    }


    private void finalizeJob() {
        currentJob.finish();
        try {
            status.goOnline();
        } catch (AlreadyInStatusException e) {
            System.out.println("Already online");
        }
        currentJob.getClient().arrived();
        rubern.getDriverAgent().getDriversWorking().remove(Driver.this);
    }

    public void assignJob(Job job) {
        this.currentJob = job;
        this.currentDestination = job.getJourney().getOrigin();
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public boolean canTakeJob(Journey journey) {
        return (status.isAvailableForJob() & journey.getPassengers() <= car.getPassengerCapacity());
    }

    public Car getCar() {
        return car;
    }
    public Status getStatus() {
        return status;
    }
    public Location getCurrentDestination() {
        return currentDestination;
    }
    public void setStatus(Status s){
        status = s;
    }
    public void addToSorter(){
        rubern.addDriver(this);
    }
    public void turnTo(Location location) {

    }

}
