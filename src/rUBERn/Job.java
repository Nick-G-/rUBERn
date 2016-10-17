package rUBERn;

// Created by nico on 9/30/16.

public class Job {

    private Driver driver;
    private Client client;
    private Journey journey;

    public Job (Driver driver, Client client, Journey journey){
        this.client = client;
        this.driver = driver;
        this.journey = journey;
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
}
