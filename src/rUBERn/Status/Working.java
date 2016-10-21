package rUBERn.Status;

import rUBERn.Driver;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

/**
 * Created by facundo on 10/21/16.
 */
public class Working implements Status {
    private Driver driver;
    public Working(Driver d){
        driver = d;
    }
    @Override
    public void goOnline() {
        driver.setStatus(new Online(driver));
    }

    @Override
    public void goOffline() throws InvalidStatusChangeException {
    throw new InvalidStatusChangeException();
    }

    @Override
    public void goWorking() throws AlreadyInStatusException {
    throw new AlreadyInStatusException();
    }
    public String toString(){
        return "Working";
    }
}
