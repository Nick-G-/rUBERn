package rUBERn;

// Created by nico on 9/30/16.

public abstract class Person implements Locatable {
    private CreditCard creditCard;
    private Location currentLocation;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }
    public int getCreditCardNumber() {
        return creditCard.getId();
    }
    public String getName() {
        return this.name;
    }
}
