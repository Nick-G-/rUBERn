package rUBERn;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by facundo on 10/13/16.
 */

public class CreditCard {
    private double balance;
    private int id;

    public CreditCard(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public CreditCard() {
        this (ThreadLocalRandom.current().nextInt(999999));

    }

    public int getId() {
        return id;
    }

    public void extract(double amount){
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void doTransactionToCreditCard(double amount, CreditCard creditCard) {
        this.extract(amount);
        creditCard.deposit(amount);
    }
}
