package rUBERn.DriverStatus;

import rUBERn.Driver;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.Job;

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
        try {
            throw new InvalidStatusChangeException();
        } catch (InvalidStatusChangeException e) {
            System.out.println("Driver " + driver.getName() + " just attempted to go Offline when he was working.");
        }
    }

    @Override
    public void goWorking() {
        try {
            throw new AlreadyInStatusException();
        } catch (AlreadyInStatusException e) {
            System.out.println("Driver " + driver.getName() + " just attempted to go Working when he already was.");
        }
    }

    @Override
    public void receiveJob(Job job) {
        driver.getJobQueue().add(job);
    }

    @Override
    public boolean isAvailableForJob() {
        return false;
    }

    @Override
    public boolean isWorking() {
        return true;
    }

    @Override
    public boolean isOnline() {
        return true;
    }

    public String toString(){
        return "Working";
    }
}
