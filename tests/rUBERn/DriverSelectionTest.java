package rUBERn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by facundo on 10/19/16.
 */
public class DriverSelectionTest {
    @Test
    public void testByDistanceToClient(){
        rUBERn rubern = new rUBERn();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(2,8),"marcos", new Car());
        Driver tito = new Driver(new CreditCard(),new Location(0,5),"Tito", new Car());
        Driver ronaldo = new Driver(new CreditCard(), new Location(3,6), "Ronaldo", new Car());
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),1,rubern);
        assertEquals(false, tito.getAvailable());
        assertEquals(true, marcos.getAvailable());
        assertEquals(true, ronaldo.getAvailable());
    }
    @Test
    public void testByCarCategory(){
        rUBERn rubern = new rUBERn();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(4,4),"marcos", new Car(1,"Berreta"));
        Driver tito = new Driver(new CreditCard(),new Location(4,4),"Tito", new Car(1,"Normal"));
        Driver ronaldo = new Driver(new CreditCard(), new Location(4,4), "Ronaldo", new Car(1,"Deluxe"));
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),1,rubern);
        assertEquals(true, tito.getAvailable());
        assertEquals(true, marcos.getAvailable());
        assertEquals(false, ronaldo.getAvailable());
    }
    @Test
    public void testByCarCapacity(){
        rUBERn rubern = new rUBERn();
        Client client = new Client(new CreditCard(), new Location(0,0), "Cliente");
        Driver marcos = new Driver(new CreditCard(),new Location(4,4),"marcos", new Car(3,"Normal"));
        Driver tito = new Driver(new CreditCard(),new Location(4,4),"Tito", new Car(4,"Normal"));
        Driver ronaldo = new Driver(new CreditCard(), new Location(4,4), "Ronaldo", new Car(2,"Normal"));
        marcos.goOnline();
        tito.goOnline();
        ronaldo.goOnline();
        rubern.addDriver(marcos, tito, ronaldo);
        client.request(new Location(30,30),4,rubern);
        assertEquals(true, marcos.getAvailable());
        assertEquals(false, tito.getAvailable());
        assertEquals(true, ronaldo.getAvailable());
    }
}