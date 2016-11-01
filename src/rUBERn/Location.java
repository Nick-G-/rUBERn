package rUBERn;

// Created by nico on 9/30/16.
import javafx.geometry.Point2D;
import org.newdawn.slick.geom.Vector2f;

import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private float x;
    private float y;

    public Location() {
        this.x = ThreadLocalRandom.current().nextLong(1000);
        this.y = ThreadLocalRandom.current().nextLong(1000);
    }
    public Location(Location location) {
        this.x = location.getX();
        this.y = location.getY();
    }
    public Location(Vector2f vector2f) {
        this.x = vector2f.getX();
        this.y = vector2f.getY();
    }
    public Location(long x, long y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Location otherLocation) {
        return applyPythagoras(this, otherLocation);
    }
    public double angleTo(Location otherLocation) {
        float adj = otherLocation.x - this.x;
        float opp = otherLocation.y - this.y;

        double hyp = distanceTo(otherLocation);

        double angleAbsolute = Math.acos(adj/hyp);
        return opp>0? angleAbsolute : -angleAbsolute;
    }

    private double applyPythagoras(Location a, Location b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public Vector2f toVector2f() {
        return new Vector2f(x,y);
    }

    public void moveX(float x) {
        this.x += x;
    }

    public boolean isInRangeOf(Location other, double range) {
        if (this.distanceTo(other) <= range)
            return true;
        return false;
    }
    public void moveY(float y) {
        this.y += y;
    }
    public void moveDistanceInAngle(float distance, double angle) {
        moveX(distance*((float)Math.cos(angle)));
        moveY(distance*((float)Math.sin(angle)));
    }
    public boolean equals(Location location){
        return location.getX() == this.x & location.getY() == this.y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
