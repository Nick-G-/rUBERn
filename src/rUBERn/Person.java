package rUBERn;

// Created by nico on 9/30/16.

import javafx.geometry.Point2D;
import org.newdawn.slick.geom.Vector2f;

public abstract class Person implements Locatable {
    private CreditCard creditCard;
    protected Location currentLocation;
    protected Location currentDestination;
    private String name;

    public Person(String name) {
        this.creditCard = new CreditCard();
        this.currentLocation = new Location();
        this.name = name;
    }
    public Person(String name, Location startingPoint) {
        this.creditCard = new CreditCard();
        this.currentLocation = new Location(startingPoint);
        this.name = name;
    }
    public Person(CreditCard creditCard, Location startingPoint, String name) {
        this.creditCard = creditCard;
        this.currentLocation = new Location(startingPoint);
        this.name = name;
    }

    public void move(double angle, double distance) {
        currentLocation.moveX((long) (Math.cos(angle)*distance));
        currentLocation.moveY((long) (Math.sin(angle)*distance));
    }
    public void moveTo(Location location){
        double angle = currentLocation.angleTo(location);
        double distance = currentLocation.distanceTo(location);
        move(angle,distance);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
    public Vector2f getCurrentLocationAsVector2f() {
        return currentLocation.toVector2f();
    }
    public int getCreditCardNumber() {
        return creditCard.getId();
    }
    public String getName() {
        return this.name;
    }
    public void getOnCar(Driver driver){
        currentLocation = driver.getCurrentLocation();
    }

    public String toString(){return name;}
    public Location getCurrentDestination() {
        return currentDestination;
    }
}
