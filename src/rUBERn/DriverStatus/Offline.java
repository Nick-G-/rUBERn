package rUBERn.DriverStatus;

import rUBERn.Driver;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.DriverCannotReceiveJobException;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.Job;

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
    }

    @Override
    public void goOffline() {
        try {
            throw new AlreadyInStatusException();
        } catch (AlreadyInStatusException e) {
            System.out.println("Driver " + driver.getName() + " just attempted to go Offline when he already was.");
        }
    }

    @Override
    public void goWorking() {
        try {
            throw new InvalidStatusChangeException();
        } catch (AlreadyInStatusException e) {
            System.out.println("Driver " + driver.getName() + " just attempted to go Working when he was offline.");
        }
    }

    @Override
    public void receiveJob(Job job) {
        try {
            throw new DriverCannotReceiveJobException();
        } catch (DriverCannotReceiveJobException e) {
            System.out.println("Driver " + driver.getName() + " just attempted to receive a job when he was offline.");
        }
    }

    @Override
    public boolean isAvailableForJob() {
        return false;
    }

    @Override
    public boolean isWorking() {
        return false;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    public String toString(){
        return "Offline";
    }
}
