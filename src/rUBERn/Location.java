package rUBERn;

// Created by nico on 9/30/16.


public class Location {
    private long x;
    private long y;
    public Location(long x, long y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Location otherLocation) {
        return applyPythagoras(this, otherLocation);
    }

    private double applyPythagoras(Location a, Location b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public void ETATo() {
    }

}
