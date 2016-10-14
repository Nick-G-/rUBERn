package rUBERn;

import java.util.Random;
import java.util.UUID;

/**
 * Created by facundo on 10/13/16.
 */

public class CreditCard {
    private double balance;
    private int id;

    public CreditCard() {
        this.id = 32;
    }

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

    public int getNumber() {
        return id;
    }
}
