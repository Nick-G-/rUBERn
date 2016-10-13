package rUBERn;// Created by nico on 9/30/16.

public class Car {
    private int passengerCapacity;
    private CarCategory category;

    public Car(int passengerCapacity, CarCategory category) {
        this.passengerCapacity = passengerCapacity;
        this.category = category;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public CarCategory getCategory() {
        return category;
    }
}
