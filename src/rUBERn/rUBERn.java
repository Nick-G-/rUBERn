package rUBERn;

// Created by nico on 9/30/16.

import java.util.ArrayList;

public class rUBERn {

    private final float fixedCost = 15;
    private final float costPerBlock = 1;
    private final int creditCardNumber = 100000;
    private DriverManager driverManager;
    // private LogisticManager logiMan;
    //private EconomicsManager ecoMan;
    //private ConsoleCommunicator consoleCom;
    public rUBERn(){
    driverManager = new DriverManager();
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void addDriver(Driver driver){
        driverManager.addDriver(driver);
    }
    public void processRequest(Client client, Location destination, int passengers) {
        //tell logiMan to match clientwith driver
        // facundo: Start developing logic in this class, then split it into the "Managers" if its too big
        if (!client.isWating()){
        Journey journey = new Journey(client.getCurrentLocation(), destination, passengers);
        Job job = new Job(driverManager.findDriverForJourney(journey), client, journey);
        job.getDriver().goBusy();

        }
    }
    public ArrayList<Driver> getDrivers(){
        return driverManager.getDrivers();
    }
}
