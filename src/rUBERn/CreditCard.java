package rUBERn;

/**
 * Created by facundo on 10/13/16.
 */
public class CreditCard {
    private double balance;
    private int id;
    public void deposit(double amount){
        if (amount > 0)
            balance += amount;
        else System.out.println("Amount entered not valid");
    }
    public void extract(double amount){
        if (amount > 0)
            balance -= amount;
        else System.out.println("Amount entered not valid");
    }
}
