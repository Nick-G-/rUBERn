package rUBERn.Operations;
import rUBERn.Job;
import rUBERn.Rubern;

public class PayOperation extends Operation{
    public PayOperation(Job job, Rubern rUBERn) {
        super(job, 15 + (job.getJourney().getDistance()* 0.1)*0.9, rUBERn);
        rUBERn.getCreditCard().doTransactionToCreditCard(amount, job.getDriver().getCreditCard());
        System.out.println(getDescription());
    }

    @Override
    String getType() {
        return "Payment";
    }

    @Override
    int getCardNumber() {
        return this.getJob().getDriver().getCreditCardNumber();
    }

    @Override
    String getDescription() {
        final String driverName = this.getJob().getDriver().getName();
        final String clientName = this.getJob().getClient().getName();
        final String journey =    this.getJob().getJourney().toString();
        final String amountPayed = super.getAmountAsString();

        return "Driver " + driverName + " was compensated $" + amountPayed + " for taking Client " + clientName + " in "+ journey + ".";
    }

    @Override
    public String getAmountAsString() {
        return "-" + super.getAmountAsString();
    }
}
