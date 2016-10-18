package rUBERn;

// Created by nico on 10/2/16.

import rUBERn.Exceptions.DriverNotFoundException;

import java.util.ArrayList;

public class DriverManager {
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ImageCalculator imageCalculator;

    public DriverManager(){
        this.imageCalculator = new ImageCalculator();
        drivers = new ArrayList<>();
    }

    private ArrayList<Driver> rankDrivers(Journey journey) {
        ArrayList<Driver> rankedDrivers = null;
        ArrayList<Driver> possibleDrivers = drivers;
        for (int i=0; i<drivers.size(); i++){
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

    public Driver findDriverForJourney(Journey journey) {
        for (Driver driver : rankDrivers(journey)) {
            if (offerJourneyToDriver(journey, driver)) {
                return driver;
            }
        }
        throw new DriverNotFoundException();
    }

    public void addDriver(Driver... drivers){
        for (Driver d : drivers)
            this.drivers.add(d);
    }

    private boolean offerJourneyToDriver(Journey journey, Driver driver) {
        return driver.evaluateOffer(journey);
    }
}
