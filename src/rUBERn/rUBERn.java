package rUBERn;

// Created by nico on 9/30/16.

public class rUBERn {

    private float fixedCost = 15;
    private float costPerBlock = 1;
    private CreditCard creditCard;
    private LogisticManager logiMan;
    private EconomicsManager ecoMan;
    private ConsoleCommunicator consoleCom;

    public rUBERn(CreditCard creditCard){}

    public int getCreditCardNumber() {
        return 0;
    }

    public void processRequest() {
        //check that client does not have a pending journey already
        //tell logiMan to match client with driver
    }

}
