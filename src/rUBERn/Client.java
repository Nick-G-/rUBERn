package rUBERn;// Created by nico on 9/30/16.

import java.util.ArrayList;

public class Client extends Person {

    public Client(CreditCard creditCard, Location startingPoint, String name) {
        super(creditCard, startingPoint, name);
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
}
