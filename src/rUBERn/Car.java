package rUBERn;// Created by nico on 9/30/16.

import org.newdawn.slick.geom.Vector2f;
import rUBERn.Categories.CarCategory;
import rUBERn.Categories.Standard;

public class Car implements Locatable {
    private int passengerCapacity;
    CarCategory category;
    private double speed;                   // meters per second, by default 5.5 (20 km/h).
    private double facingAngle;
    private Location currentLocation;

    public Car() {
        this.passengerCapacity = 3;
        this.category = new Standard();
        this.speed = 70;
    }

    public Car(int passengerCapacity, CarCategory category) {
        this(passengerCapacity, category, 70, 0);
    }

    public Car(int passengerCapacity, CarCategory category, double speed, double facingAngle) {
        this.passengerCapacity = passengerCapacity;
        this.category = category;
        this.speed = speed;
        this.facingAngle = facingAngle;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void moveForwards(float distance) {
        currentLocation.moveDistanceInAngle(distance, facingAngle);
    }
    public CarCategory getCategory() {
        return category;
    }
    public double getSpeed(){
        return speed;
    }

    @Override
    public Location getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public Vector2f getCurrentLocationAsVector2f() {
        return currentLocation.toVector2f();
    }
}
