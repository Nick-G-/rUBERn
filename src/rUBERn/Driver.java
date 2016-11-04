package rUBERn;// Created by nico on 9/30/16.

import rUBERn.DriverStatus.Offline;
import rUBERn.DriverStatus.Status;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Driver extends Person {
    private Car car;
    private Status status;
    private LinkedBlockingQueue<Job> jobQueue = new LinkedBlockingQueue<>();
    private Job currentJob;
    private Rubern rubern;

    public Queue<Job> getJobQueue() {
        return jobQueue;
    }

    public Driver(String name, Rubern rubern) {
        super(name);
        this.car = new Car();
        status = new Offline(this);
        this.rubern = rubern;

    }

    public Driver(CreditCard creditCard, Location startingPoint, String name, Car car, Rubern rubern) {
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

    public void goOnline() {
        status.goOnline();
    }

    public void goOffline() {
        status.goOffline();
    }

    public void goBusy() {
        status.goWorking();
    }

    public boolean evaluateOffer(Journey journey, Client client) {
        return true;
        //return new RequestPopup(journey,client).getAnswer();
    }

    public void work(int delta) {
        if(!currentJob.isFinished()) {
            Location pickup = currentJob.getJourney().getOrigin();
            Location destination = currentJob.getJourney().getDestination();
            float moveSpeed = (float) car.getSpeed() * delta/1000;

            currentLocation.moveDistanceInAngle(moveSpeed, currentLocation.angleTo(currentDestination));

            if (currentLocation.isInRangeOf(pickup, 1)) {
                currentJob.getClient().getOnCar(this);
                currentDestination = destination;
            }

            if (currentLocation.isInRangeOf(destination, 1)) {
                finalizeJob();
            }
        }
    }

    public void assignJob(Job job) {
        status.receiveJob(job);
    }

    public void setCurrentJob(Job job) {
        this.currentJob = job;
        this.currentDestination = job.getJourney().getOrigin();
    }

    public void finalizeJob() {
        currentJob.finish();
        currentJob.getClient().arrived();
        rubern.processJobFinalized(currentJob);

        if (jobQueue.isEmpty()) {
            goOnline();
            return;
        }
        setCurrentJob(jobQueue.remove());
    }

    public Duration ETATo(Location location) {
        return Duration.ofSeconds((long) (this.getCurrentLocation().distanceTo(location) / car.getSpeed()));
    }

    public boolean canTakeJob(Journey journey) {
        return (journey.getPassengers() <= car.getPassengerCapacity());
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

    public void setStatus(Status s) {
        status = s;
    }

    public void addToSorter() {
        rubern.addDriver(this);
    }
}
