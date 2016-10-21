package rUBERn;

import org.junit.Test;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

import static org.junit.Assert.assertEquals;

/**
 * Created by facundo on 10/19/16.
 */
public class DriverSelectionTest {
    @Test
    public void testByDistanceToClient() throws AlreadyInStatusException, InvalidStatusChangeException {
        Rubern rubern = new Rubern();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(2,8),"marcos", new Car(),rubern);
        Driver tito = new Driver(new CreditCard(),new Location(0,5),"Tito", new Car(),rubern);
        Driver ronaldo = new Driver(new CreditCard(), new Location(3,6), "Ronaldo", new Car(),rubern);
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),1,rubern);
        assertEquals("Working", tito.getStatus().toString());
        assertEquals("Online", marcos.getStatus().toString());
        assertEquals("Online", ronaldo.getStatus().toString());
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
        assertEquals("Online", tito.getStatus().toString());
        assertEquals("Online", marcos.getStatus().toString());
        assertEquals("Working", ronaldo.getStatus().toString());
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
        assertEquals("Online", marcos.getStatus().toString());
        assertEquals("Working", tito.getStatus().toString());
        assertEquals("Online", ronaldo.getStatus().toString());
    }
}