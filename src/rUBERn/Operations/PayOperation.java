package rUBERn.Operations;
import rUBERn.Job;

public class PayOperation extends Operation{
    public PayOperation(Job job) {
        super(job, 15 + (job.getJourney().getDistance()* 0.1)*0.9);
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
        String driverName = this.getJob().getDriver().getName();
        String clientName = this.getJob().getClient().getName();
        String journeyOrigin = this.getJob().getJourney().getOrigin().toString();
        String journeyDestination = this.getJob().getJourney().getDestination().toString();
        String amountPayed = super.getAmountAsString();

        return "Driver " + driverName + " was compensated $" + amountPayed + " for taking Client" + clientName + " from " + journeyOrigin + " to " + journeyDestination + ".";
    }

    @Override
    public String getAmountAsString() {
        return "-" + super.getAmountAsString();
    }
}
