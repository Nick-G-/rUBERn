package rUBERn;

// Created by nico on 9/30/16.

public abstract class Person implements Locatable {
    private CreditCard creditCard;
    private Location currentLocation;
    private String name;

    public Person(String name) {
        this.creditCard = new CreditCard();

    }
    public Person(CreditCard creditCard, Location startingPoint, String name) {
        this.creditCard = creditCard;
        this.currentLocation = startingPoint;
        this.name = name;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public int getCreditCardNumber() {
        return creditCard.getId();
    }
}
