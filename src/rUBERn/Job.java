package rUBERn;

// Created by nico on 9/30/16.

import java.io.Serializable;

public class Job implements Serializable {

    private Driver driver;
    private Client client;
    private Journey journey;
    private boolean finished;

    public Job (Driver driver, Client client, Journey journey){
        this.client = client;
        this.driver = driver;
        this.journey = journey;
        finished = false;
    }

    public Driver getDriver() {
        return driver;
    }

    public Client getClient() {
        return client;
    }

    public Journey getJourney() {
        return journey;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }
    public boolean isFinished(){
        return finished;
    }
    public void finish(){
        finished = true;
    }
}
