package rUBERn;

// Created by nico on 10/1/16.

public class Operation {
    private int operationId;
    private String operationType;
    private java.util.Calendar time;
    private int creditcardNumber;
    private String description;
    private double amount;

    public Operation(int id, String operationType, int creditcardNumber, String description, double amount){
        this.operationId = id;
        this.operationType = operationType;
        this.creditcardNumber = creditcardNumber;
        this.description = description;
        this.amount = amount;
    }

}
