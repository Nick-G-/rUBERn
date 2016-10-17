package rUBERn;// Created by nico on 9/30/16.

public class Car {
    private int passengerCapacity;
    private String category;
    private double speed;                   // meters per second, by default 5.5 (20 km/h).

    public Car() {
        this.passengerCapacity = 3;
        this.category = "Normal";
        this.speed = 5.5;
    }

    public Car(int passengerCapacity, String category) {
        this.passengerCapacity = passengerCapacity;
        this.category = category;
        this.speed = 5.5;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getCategory() {
        return category;
    }
    public double getSpeed(){
        return speed;
    }
}
