package rUBERn;

// Created by nico on 10/2/16.

import rUBERn.Exceptions.DriverNotFoundException;

import java.util.ArrayList;

public class DriverAgent {
    private ArrayList<Driver> drivers;
    private ArrayList<Driver> driversWorking;
    public DriverAgent(){
        drivers = new ArrayList<>();
        driversWorking = new ArrayList<>();
    }
    private ArrayList<Driver> rankDrivers(Journey journey) {
        ArrayList<Driver> possibleDrivers = new ArrayList<>();
            for (Driver driver : drivers){
                if(driver.canTakeJob(journey))
                    possibleDrivers.add(driver);
            }

            possibleDrivers.sort(new DriverComparatorByImageForJourney(journey));
            return possibleDrivers;
        }

    public Driver findDriverForJourney(Journey journey, Client client) {
        for (Driver driver : rankDrivers(journey)) {
            if (offerJourneyToDriver(journey, driver,client)) {
                return driver;
            }
        }
        throw new DriverNotFoundException();
    }

    public void addDriver(Driver... drivers){
        for (Driver d : drivers)
            this.drivers.add(d);
    }
    public void removeDriver(Driver driver){
        this.drivers.remove(driver);
    }

    private boolean offerJourneyToDriver(Journey journey, Driver driver, Client client) {
        boolean response = driver.evaluateOffer(journey, client);
        if (response) {
            driversWorking.add(driver);
        }
        return response;
    }
    public ArrayList<Driver> getDrivers(){
        return drivers;
    }
    public ArrayList<Driver> getDriversWorking() {
        return driversWorking;
    }
}
