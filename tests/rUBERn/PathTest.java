package rUBERn;

import org.junit.Test;

import static org.junit.Assert.*;


// Created by nico on 11/2/16.

public class PathTest {
    @Test
    public void getPathLength() throws Exception {
        Location loc00 = new Location(0,0);
        Location loc05 = new Location(0,5);
        Location loc55 = new Location(5,5);
        Location loc08 = new Location(0,8);

        Path path01 = new Path(loc00, loc05, loc55);
        Path path02 = new Path(loc00, loc05, loc08);

        assertEquals(10, path01.getPathLength(), 0.1);
        assertEquals(8, path02.getPathLength(), 0.1);
    }

}