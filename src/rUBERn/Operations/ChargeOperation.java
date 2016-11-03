package rUBERn.Operations;

// Created by nico on 10/16/16.
import rUBERn.Job;
import rUBERn.Rubern;

public class ChargeOperation extends Operation{

    public ChargeOperation(Job job, Rubern rUBERn) {
        super(job, 15 + job.getJourney().getDistance()* 0.1, rUBERn);
        job.getClient().getCreditCard().doTransactionToCreditCard(this.amount, rUBERn.getCreditCard());
        System.out.println(getDescription());
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

        return "Client " + clientName + " was charged $" + amountCharged + " for journey from " + journeyOrigin + " to " + journeyDestination + " by Driver " + driverName + ".";
    }
}
