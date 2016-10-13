package rUBERn;// Created by nico on 9/30/16.

import java.util.ArrayList;

public class Client implements Locatable {
    private CreditCard creditCard;
    private int id;
    private Location location;
    private ArrayList<Location> customLocations;
    public Client(int id){
        this.id = id;
    }

    public void assignCreditCard(CreditCard creditCard){
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void request(Location destination, int passengers) {

    }

    public void request(Location destination) {
        request(destination, 1);
    }

    public void waitForDriver() {
    }

    public void leave() {
    }

    public int getId() {
        return id;
    }

    @Override
    public Location getLocation() {
        return null;
    }
}
