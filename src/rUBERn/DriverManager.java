package rUBERn;

// Created by nico on 10/2/16.

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
        return rankedDrivers;
    }

    public void findDriverForJob(Job job) {

    }
    public void addDriver(Driver... drivers){
        for (int i=0;i<drivers.length ;i++)
        this.drivers.add(drivers[i]);
    }

    private void offerJobToDriver(Job job, Driver driver) {
        driver.evaluateOffer(job.getJourney());
    }
}
