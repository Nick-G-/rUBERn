package rUBERn;

import org.junit.Test;

import static org.junit.Assert.*;


// Created by nico on 10/17/16.

public class PersonTest {
    @Test
    public void move() throws Exception {
        double tau = Math.PI*2;

        Location origin = new Location(0,0);
        Driver dan = new Driver("Dan", origin, new Rubern());
                                            // starts in origin
        dan.move(0, 5);                     // move 5m right
        assertLocatableIsAt(dan, 5, 0);     // should be at (5,0)

        dan.move(tau/4, 5);                 // move 5m up
        assertLocatableIsAt(dan, 5, 5);     // should be at (5,5)

        dan.move(dan.getCurrentLocation().angleTo(origin), dan.getCurrentLocation().distanceTo(origin)); // move to origin
        assertLocatableIsAt(dan, 0, 0); // should be at (0,0)
    }
    private void assertLocatableIsAt(Locatable locatable, long coordX, long coordY) {
        float locatableCurrentX = locatable.getCurrentLocation().getX();
        float locatableCurrentY = locatable.getCurrentLocation().getY();

        assertEquals(coordX, locatableCurrentX, 0.1);
        assertEquals(coordY, locatableCurrentY, 0.1);
    }

}