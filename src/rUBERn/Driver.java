package rUBERn;// Created by nico on 9/30/16.

public class Driver extends Person {
    private Car car;
    private Boolean isOnline;
    private Boolean isAvailable;

    public Driver(String name) {
        super(name);
        this.car = new Car();
    }
    public Driver(CreditCard creditCard, Location startingPoint, String name, Car car) {
        super(creditCard, startingPoint, name);
        this.car = car;
    }

    public void goOnline() {
        isOnline = true;
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

    public Car getCar() {
        return car;
    }
}
