package rUBERn;

import org.junit.Test;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

import static org.junit.Assert.*;

/**
 * Created by facundo on 10/20/16.
 */
public class LocationMovingTest {
    @Test
    public void testMoving() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();
        Client client = new Client(new CreditCard(), new Location(0, 0), "Cliente");
        assertEquals(0,client.getCurrentLocation().getX());
        assertEquals(0,client.getCurrentLocation().getY());

        Driver tito = new Driver(new CreditCard(), new Location(0, 5), "Tito", new Car(),rubern);
        tito.goOnline();
        rubern.addDriver(tito);
        client.request(new Location(30, 30), 1, rubern);
        assertEquals(30,client.getCurrentLocation().getX());
        assertEquals(30,client.getCurrentLocation().getY());
        tito.moveTo(new Location(40,2094));
        assertEquals(30,client.getCurrentLocation().getX());
        assertEquals(30,client.getCurrentLocation().getY());

    }
}