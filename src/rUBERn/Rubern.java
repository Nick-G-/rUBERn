package rUBERn;

// Created by nico on 9/30/16.

import rUBERn.Operations.ChargeOperation;
import rUBERn.Operations.PayOperation;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Rubern {

    public CreditCard getCreditCard() {
        return creditCard;
    }

    private CreditCard creditCard = new CreditCard(100000);
    private double realEarnings = 0;
    private MoneyCalculator calculator;
    private DriverAgent driverAgent;
    private ArrayList<Client> clients;
    private Timer timer;
    private int deltaTime;

    public Rubern(){
        deltaTime = 16; // 62.5 FPS (1000/62.5 = 16)
        driverAgent = new DriverAgent();
        calculator = new MoneyCalculator();
        clients = new ArrayList<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            update();
            }
        },0,deltaTime);
    }

    private void update() {
        //WARNING using a for each loop here causes java Time library to cause an exception when we remove a driver from the list
        //http://stackoverflow.com/questions/18448671/how-to-avoid-concurrentmodificationexception-while-removing-elements-from-arr
        // see answer by Dima Naychuk
        for (int i =0; i<driverAgent.getDriversWorking().size(); i++)
            driverAgent.getDriversWorking().get(i).work(deltaTime);
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
        if (!client.isWaiting()){
            Location origin = new Location(client.getCurrentLocation());
            Journey journey = new Journey(origin,destination,passengers);

            Driver driver = driverAgent.findDriverForJourney(journey,client);
            Job job = new Job(driver,client,journey);
            driver.getStatus().receiveJob(job);


            ChargeOperation charge = new ChargeOperation(job, this);
        }
    }

    public Double getRealEarnings() {
        return realEarnings;
    }

    public void processJobFinalized(Job job) {
        PayOperation payment = new PayOperation(job, this);
        realEarnings += payment.getAmount();
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
