package rUBERn;

import static org.junit.Assert.*;


// Created by nico on 10/16/16.

public class LocationTest {
    @org.junit.Test
    public void distanceTo() {
        Location origin = new Location(0,0);
        Location point = new Location(3,4);

        assertEquals(5, origin.distanceTo(point), 0.1);
        assertEquals(5, point.distanceTo(origin), 0.1);
    }

    @org.junit.Test
    public void angleTo() {
        double tau = Math.PI*2;

        double eighthTurn           = tau/8;
        double quarterTurn          = tau/4;
        double negativeQuarterTurn  = -tau/4;

        Location origin                     = new Location(0,0);
        Location pointAt0                   = new Location(5,0);
        Location pointAtEighthTurn          = new Location(3,3);
        Location pointAtQuarterTurn         = new Location(0,1);
        Location pointAtNegativeQuarterTurn = new Location(0,-3);

        double o_v_0                    = origin.angleTo(pointAt0);
        double o_v_QuarterTurn          = origin.angleTo(pointAtQuarterTurn);
        double o_v_EighthTurn           = origin.angleTo(pointAtEighthTurn);
        double o_v_NegativeQuarterTurn  = origin.angleTo(pointAtNegativeQuarterTurn);

        assertEquals(0, o_v_0, 0.1);
        assertEquals(eighthTurn, o_v_EighthTurn, 0.1);
        assertEquals(quarterTurn, o_v_QuarterTurn, 0.1);
        assertEquals(negativeQuarterTurn, o_v_NegativeQuarterTurn, 0.1);
    }

}