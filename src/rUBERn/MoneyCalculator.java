package rUBERn;

/**
 * Created by facundo on 10/20/16.
 */
public class MoneyCalculator {

    public double calculateCharge(Job job){
        //charge to client 1$ * 100m + 15
        double answer = 15;
        answer += job.getJourney().getDistance() * 0.1;
        return answer;
    }
    public double calculatePay(Job job){
    return (calculateCharge(job) / 100) * 90;
    }
}
