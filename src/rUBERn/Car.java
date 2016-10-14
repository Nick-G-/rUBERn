package rUBERn;// Created by nico on 9/30/16.

public class Car {
    private int passengerCapacity;
    private String category;

    public Car() {
        this.passengerCapacity = 3;
        this. category = "Normal";
    }

    public Car(int passengerCapacity, String category) {
        this.passengerCapacity = passengerCapacity;
        this.category = category;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getCategory() {
        return category;
    }
}
