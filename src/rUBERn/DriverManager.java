package rUBERn;

// Created by nico on 10/2/16.

import java.util.ArrayList;

public class DriverManager {
    private ArrayList<Driver> drivers;
    private ImageCalculator imageCalculator;

    private ArrayList<Driver> rankDrivers(Journey journey) {
        ArrayList<Driver> rankedDrivers = null;
        return rankedDrivers;
    }

    public void findDriverForJob(Job job) {

    }


    private void offerJobToDriver(Job job, Driver driver) {
        driver.evaluateOffer(job.getJourney());
    }
}
