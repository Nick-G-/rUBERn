package rUBERn.Operations;

// Created by nico on 10/16/16.
import rUBERn.Job;

public class ChargeOperation extends Operation{

    public ChargeOperation(Job job, double amount) {
        super(job, amount);

    }

    @Override
    String getType() {
        return "Charge";
    }

    @Override
    int getCardNumber() {
        return this.getJob().getClient().getCreditCardNumber();
    }

    @Override
    String getDescription() {
        String driverName = this.getJob().getDriver().getName();
        String clientName = this.getJob().getClient().getName();
        String journeyOrigin = this.getJob().getJourney().getOrigin().toString();
        String journeyDestination = this.getJob().getJourney().getDestination().toString();
        String amountCharged = getAmountAsString();

        return "Client " + clientName + " was charged $" + amountCharged + " for being taken from " + journeyOrigin + " to " + journeyDestination + " by Driver " + driverName + ".";
    }
}
