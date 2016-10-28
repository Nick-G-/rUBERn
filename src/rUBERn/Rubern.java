package rUBERn;

// Created by nico on 9/30/16.

import java.util.ArrayList;

public class Rubern {

    private final float fixedCost = 15;
    private final float costPerBlock = 1;
    private final int creditCardNumber = 100000;
    private MoneyCalculator calculator;
    private DriverAgent driverAgent;
    private ArrayList<Client> clients;
    //private Logger log;
    public Rubern(){
        driverAgent = new DriverAgent();
      //  log = new Logger();
        calculator = new MoneyCalculator();
        clients = new ArrayList<>();
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void addDriver(Driver... drivers){
        driverAgent.addDriver(drivers);
    }
    public void addClient(Client client){
        clients.add(client);
    }
    public void removeDriver(Driver driver){
        driverAgent.removeDriver(driver);
    }
    public void processRequest(Client client, Location destination, int passengers){
        if (!client.isWating()){
            Location origin = new Location(client.getCurrentLocation());
            Journey journey = new Journey(origin,destination,passengers);
            Job job = new Job(driverAgent.findDriverForJourney(journey,client),client,journey);
            //log.log(new ChargeOperation(job, calculator.calculateCharge(job)));
            //log.log(new PayOperation(job, calculator.calculatePay(job)));
        }
    }
    public ArrayList<Driver> getDrivers(){
        return driverAgent.getDrivers();
    }
    public DriverAgent getDriverAgent() {
        return driverAgent;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

}
