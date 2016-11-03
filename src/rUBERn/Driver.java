package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.DriverStatus.Offline;
import rUBERn.DriverStatus.Status;

import java.time.Duration;
import java.util.PriorityQueue;
import java.util.Queue;

public class Driver extends Person {
    private Car car;
    private Status status;
    private PriorityQueue<Job> jobQueue = new PriorityQueue<>();
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
        if (true) {
            return true;
        }
        return false;
    }

    private void doOffer(Journey journey, Client client) {
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

    public void work(int delta) {
        Location pickup = currentJob.getJourney().getOrigin();
        Location destination = currentJob.getJourney().getDestination();
        float moveSpeed = (float) car.getSpeed() * delta / 100;

        currentLocation.moveDistanceInAngle(moveSpeed, currentLocation.angleTo(currentDestination));

        if (currentLocation.isInRangeOf(pickup, 1)) {
            currentJob.getClient().getOnCar(this);
            currentDestination = destination;
        }

        if (currentLocation.isInRangeOf(destination, 1)) {
            currentDestination = new Location();
            finalizeJob();
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
        currentJob.getClient().getOffCar();

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
        return (status.isAvailableForJob() & journey.getPassengers() <= car.getPassengerCapacity());
    }

    private void idle() {
        currentDestination = new Location();
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
