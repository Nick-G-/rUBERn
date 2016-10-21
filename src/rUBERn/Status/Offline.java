package rUBERn.Status;

import rUBERn.Driver;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

/**
 * Created by facundo on 10/21/16.
 */
public class Offline implements Status {
    private Driver driver;
    public Offline(Driver c){
        this.driver = c;
    }
    @Override
    public void goOnline() {
        driver.setStatus(new Online(driver));
        driver.addToSorter();
    }

    @Override
    public void goOffline() throws AlreadyInStatusException {
    throw new AlreadyInStatusException();
    }

    @Override
    public void goWorking() throws InvalidStatusChangeException {
    throw new InvalidStatusChangeException();
    }
    public String toString(){
        return "Offline";
    }
}
