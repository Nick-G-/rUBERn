package rUBERn;

// Created by nico on 9/30/16.
import java.time.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private long x;
    private long y;

    public Location() {
        this.x = ThreadLocalRandom.current().nextLong(1000);
        this.y = ThreadLocalRandom.current().nextLong(1000);
    }
    public Location(Location location) {
        this.x = location.getX();
        this.y = location.getY();
    }
    public Location(long x, long y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Location otherLocation) {
        return applyPythagoras(this, otherLocation);
    }
    public double angleTo(Location otherLocation) {
        long adj = otherLocation.x - this.x;
        long opp = otherLocation.y - this.y;

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

    public void moveX(long x) {
        this.x += x;
    }

    public void moveY(long y) {
        this.y += y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
