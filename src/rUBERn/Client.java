package rUBERn;// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

public class Client extends Person {
    private boolean pendingJourney;

    public Client(String name) {
        super(name);
        pendingJourney = false;
    }
    public Client(String name, Location startingLocation) {
        super(name, startingLocation);
    }
    public Client(CreditCard creditCard, Location startingPoint, String name) {
        super(creditCard, startingPoint, name);
        pendingJourney = false;
    }
    public void request(Location destination, int passengers, Rubern rubern){
        rubern.processRequest(Client.this, destination,passengers);
        waitForDriver();
    }

    public void request(Location destination, Rubern rubern){
        request(destination, 1, rubern);
    }

    public void waitForDriver() {
        pendingJourney = true;
    }
    public boolean isWaiting(){
    return pendingJourney;
    }
    public void arrived(){
        pendingJourney = false;
    }
}
