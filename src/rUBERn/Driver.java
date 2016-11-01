package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.GUI.RequestPopup;
import rUBERn.Status.Offline;
import rUBERn.Status.Status;
import java.time.Duration;
import java.util.Stack;

public class Driver extends Person {
    private Car car;
    private Status status;
    private Job currentJob;
    private Job nextJob;
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
            return true;
        }
        return false;
    }


    public void work(int delta) {

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



    private void finalizeJob() {
        currentJob.finish();
        try {
            status.goOnline();
        } catch (AlreadyInStatusException e) {
            System.out.println("Already online");
        }
        currentJob.getClient().arrived();
        rubern.getDriverAgent().getDriversWorking().remove(Driver.this);
        if (!(nextJob == null)) {
            rubern.getDriverAgent().getDriversWorking().add(Driver.this);
            currentJob = nextJob;
            currentDestination = nextJob.getJourney().getOrigin();
            goBusy();
            nextJob = null;
        }
    }

    public void assignJob(Job job) {
        if (status.isOnline()) {
            this.currentJob = job;
            this.currentDestination = job.getJourney().getOrigin();
            goBusy();
        }else if (status.isWorking()){
            nextJob = job;
        }
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long)(this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public boolean canTakeJob(Journey journey) {
        return (currentLocation.distanceTo(journey.getOrigin()) < 500 & journey.getPassengers() <= car.getPassengerCapacity());
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
