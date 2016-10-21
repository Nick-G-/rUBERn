package rUBERn;

// Created by nico on 9/30/16.

import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

import java.io.IOException;
import java.util.ArrayList;

public class Rubern {

    private final float fixedCost = 15;
    private final float costPerBlock = 1;
    private final int creditCardNumber = 100000;
    private MoneyCalculator calculator;
    private DriverSorter driverSorter;
    //private Logger log;
    public Rubern(){
        driverSorter = new DriverSorter();
      //  log = new Logger();
        calculator = new MoneyCalculator();
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void addDriver(Driver... drivers){
        driverSorter.addDriver(drivers);
    }
    public void processRequest(Client client, Location destination, int passengers) throws AlreadyInStatusException, InvalidStatusChangeException {
        if (!client.isWating()){
            Location origin = new Location(client.getCurrentLocation());
            Journey journey = new Journey(origin,destination,passengers);
            Job job = new Job(driverSorter.findDriverForJourney(journey,client),client,journey);
            //log.log(new ChargeOperation(job, calculator.calculateCharge(job)));
            //log.log(new PayOperation(job, calculator.calculatePay(job)));
        }
    }
    public ArrayList<Driver> getDrivers(){
        return driverSorter.getDrivers();
    }
}
