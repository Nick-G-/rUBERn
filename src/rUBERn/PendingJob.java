package rUBERn;

// Created by nico on 10/30/16.

public class PendingJob {
    private Client client;
    private Journey journey;

    public PendingJob(Client client, Journey journey) {
        this.client = client;
        this.journey = journey;
    }

    public Client getClient() {
        return client;
    }

    public Journey getJourney() {
        return journey;
    }
}
