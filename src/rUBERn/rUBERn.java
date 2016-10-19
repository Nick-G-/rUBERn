package rUBERn;

// Created by nico on 9/30/16.

import java.util.ArrayList;

public class rUBERn {

    private final float fixedCost = 15;
    private final float costPerBlock = 1;
    private final int creditCardNumber = 100000;
    private DriverManager driverManager;
    public rUBERn(){
    driverManager = new DriverManager();
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void addDriver(Driver... drivers){
        driverManager.addDriver(drivers);
    }
    public void processRequest(Client client, Location destination, int passengers) {
        if (!client.isWating()){
        Journey journey = new Journey(client.getCurrentLocation(), destination, passengers);
        Job job = new Job(driverManager.findDriverForJourney(journey), client, journey);
        }
    }
    public ArrayList<Driver> getDrivers(){
        return driverManager.getDrivers();
    }
}
