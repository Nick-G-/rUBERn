package rUBERn;

// Created by nico on 9/30/16.

import java.io.IOException;
import java.util.ArrayList;

public class rUBERn {

    private final float fixedCost = 15;
    private final float costPerBlock = 1;
    private final int creditCardNumber = 100000;
    private MoneyCalculator calculator;
    private DriverSorter driverSorter;
    private Logger log;
    public rUBERn(){
        driverSorter = new DriverSorter();
        log = new Logger();
        calculator = new MoneyCalculator();
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void addDriver(Driver... drivers){
        driverSorter.addDriver(drivers);
    }
    public void processRequest(Client client, Location destination, int passengers){
        if (!client.isWating()){
            Journey journey = new Journey(client.getCurrentLocation(),destination,passengers);
            Job job = new Job(driverSorter.findDriverForJourney(journey,client),client,journey);
            log.log(new ChargeOperation(job, calculator.calculateCharge(job)));
            log.log(new PayOperation(job, calculator.calculatePay(job)));
        }
    }
    public ArrayList<Driver> getDrivers(){
        return driverSorter.getDrivers();
    }
}
