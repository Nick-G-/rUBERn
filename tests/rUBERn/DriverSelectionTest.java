package rUBERn;

import org.junit.Test;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by facundo on 10/19/16.
 */
public class DriverSelectionTest {
    @Test
    public void testByDistanceToClient() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver furthestDriver = new Driver(new CreditCard(),new Location(2,8),"marcos", new Car(),rubern);
        Driver closestDriver = new Driver(new CreditCard(),new Location(0,5),"Tito", new Car(),rubern);
        Driver ronaldo = new Driver(new CreditCard(), new Location(3,6), "Ronaldo", new Car(),rubern);
        furthestDriver.goOnline();
        closestDriver.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(furthestDriver, closestDriver, ronaldo);
        client.request(new Location(30,30),1,rubern);
        assertEquals(client.getCurrentLocation().toString(), closestDriver.getCurrentLocation().toString());
        assertNotEquals(client.getCurrentLocation().toString(), furthestDriver.getCurrentLocation().toString());
        assertEquals(client.getCurrentLocation().toString(), ronaldo.getCurrentLocation().toString());
    }
    @Test
    public void testByCarCategory() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(4,4),"marcos", new Car(1,"Berreta"),rubern);
        Driver tito = new Driver(new CreditCard(),new Location(4,4),"Tito", new Car(1,"Normal"),rubern);
        Driver ronaldo = new Driver(new CreditCard(), new Location(4,4), "Ronaldo", new Car(1,"Deluxe"),rubern);
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),1,rubern);
        assertEquals(client.getCurrentLocation().toString(), ronaldo.getCurrentLocation().toString());
        assertNotEquals(client.getCurrentLocation().toString(), marcos.getCurrentLocation().toString());
        assertNotEquals(client.getCurrentLocation().toString(), tito.getCurrentLocation().toString());
    }
    @Test
    public void testByCarCapacity() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(4,4),"marcos", new Car(3,"Normal"),rubern);
        Driver tito = new Driver(new CreditCard(),new Location(4,4),"Tito", new Car(4,"Normal"),rubern);
        Driver ronaldo = new Driver(new CreditCard(), new Location(4,4), "Ronaldo", new Car(2,"Normal"),rubern);
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),4,rubern);
        assertEquals(client.getCurrentLocation().toString(), tito.getCurrentLocation().toString());
        assertNotEquals(client.getCurrentLocation().toString(), marcos.getCurrentLocation().toString());
        assertNotEquals(client.getCurrentLocation().toString(), ronaldo.getCurrentLocation().toString());
    }

    @Test
    public void testSelectionByDistanceToClient() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();

        Driver first = new Driver("first", new Location(0,5), rubern);
        Driver second = new Driver("second", new Location(-5,-5), rubern);
        Driver third = new Driver("third", new Location(15,0), rubern);

        first.goOnline();

        Client client = new Client("client", new Location(0,0));
        Journey journey = new Journey(new Location(0,0), new Location(50,50), 0);

        assertEquals(first, rubern.getDriverAgent().findDriverForJourney(journey, client));
    }
}