package rUBERn;// Created by nico on 9/30/16.

import java.util.ArrayList;

public class Client extends Person {
    private boolean pendingJourney;

    public Client(String name) {
        super(name);
        pendingJourney = false;
    }
    public Client(CreditCard creditCard, Location startingPoint, String name) {
        super(creditCard, startingPoint, name);
    }
    public void request(Location destination, int passengers, rUBERn rubern) {
        rubern.processRequest(Client.this, destination,passengers);
    }

    public void request(Location destination, rUBERn rubern) {
        request(destination, 1, rubern);
    }

    public void waitForDriver() {
    pendingJourney = true;
    }
    public boolean isWating(){
    return pendingJourney;
    }
    public void arrived(){
        pendingJourney = false;
    }
    public void leave() {
    }
}
