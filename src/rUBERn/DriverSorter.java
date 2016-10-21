package rUBERn;

// Created by nico on 10/2/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.DriverNotFoundException;
import rUBERn.Exceptions.InvalidStatusChangeException;

import java.util.ArrayList;

public class DriverSorter {
    private ArrayList<Driver> drivers;
    private ImageCalculator imageCalculator;
    public DriverSorter(){
        this.imageCalculator = new ImageCalculator();
        drivers = new ArrayList<>();
    }

    private ArrayList<Driver> rankDrivers(Journey journey) {
        ArrayList<Driver> rankedDrivers = new ArrayList<Driver>();
        ArrayList<Driver> possibleDrivers = new ArrayList<Driver>();
            for (int i=0; i<drivers.size(); i++){
                if(drivers.get(i).getCar().getPassengerCapacity() >= journey.getPassengers())
                    possibleDrivers.add(drivers.get(i));
            }
            for (int i=0; i<possibleDrivers.size(); i++){
                Driver bestDriver = bestDriver(journey,possibleDrivers);
                rankedDrivers.add(bestDriver);
                possibleDrivers.remove(possibleDrivers.indexOf(bestDriver));
            }
            return rankedDrivers;
        }

    private Driver bestDriver(Journey journey, ArrayList<Driver> driversList){
        Driver bestDriver = driversList.get(0);
        for (int i=0; i<driversList.size(); i++){
            if(imageCalculator.calculateImageCost(bestDriver,journey)>imageCalculator.calculateImageCost(driversList.get(i),journey)){
                bestDriver = driversList.get(i);
            }
        }
        return bestDriver;
    }

    public Driver findDriverForJourney(Journey journey, Client client) throws AlreadyInStatusException, InvalidStatusChangeException {
        for (Driver driver : rankDrivers(journey)) {
            if (offerJourneyToDriver(journey, driver, client)) {
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

    private boolean offerJourneyToDriver(Journey journey, Driver driver, Client client) throws AlreadyInStatusException, InvalidStatusChangeException {
        return driver.evaluateOffer(journey, client);
    }
    public ArrayList<Driver> getDrivers(){
        return drivers;
    }
}
