package rUBERn;

// Created by nico on 11/2/16.

import java.util.ArrayList;
import java.util.ListIterator;

public class Path {
    ArrayList<Location> points;

    public Path (Location... locations) {
        points = new ArrayList<>();

        for (Location location : locations)
            this.points.add(location);
    }


    public double getPathLength() {
        double length = 0;
        ListIterator<Location> i = points.listIterator();
        ListIterator<Location> i2 = points.listIterator(1);

        while (i2.hasNext())
            length += i.next().distanceTo(i2.next());

        return length;
    }
}
