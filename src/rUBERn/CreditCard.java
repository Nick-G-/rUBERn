package rUBERn;

import java.util.Random;

/**
 * Created by facundo on 10/13/16.
 */

public class CreditCard {
    private double balance;
    private int id;

    public CreditCard() {
        this.id = new Random().nextInt(999999);
    }

    public int getId() {
        return id;
    }

    public void extract(){ // a mock method to simulate payments

    }
}
