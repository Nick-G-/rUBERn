package rUBERn.Operations;

// Created by nico on 10/1/16.

//import java.io.IOException;

import rUBERn.Job;
import rUBERn.Rubern;

import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class Operation {
    private UUID id;
    private Instant instant;
    private rUBERn.Job job;
    protected double amount;
    private OperationFiler operationFiler = new OperationFiler();
    private String operationData;
    private Rubern rUBERn;



    public Operation(Job job, double amount, Rubern rUBERn) {
        this.id = UUID.randomUUID();
        this.instant = Instant.now();
        this.job = job;
        this.amount = amount;
        this.operationData = toArchiveFormat();
        this.operationFiler.FileOperation(operationData);
        this.rUBERn = rUBERn;

    }

    public String toArchiveFormat() {
        String id   = this.id.toString();
        String type = getType();
        String date = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(instant.atZone(ZoneId.systemDefault()));
        String time = DateTimeFormatter.ofPattern("HH:mm").format(instant.atZone(ZoneId.systemDefault()));
        String cardNumber       = String.valueOf(getCardNumber());
        String amountAsString   = this.getAmountAsString();
        String description      = getDescription();

        return  id              + "\n" +
                type            + "\n" +
                date            + "\n" +
                time            + "\n" +
                cardNumber      + "\n" +
                amountAsString  + "\n" +
                description;
    }

    abstract String getType();
    abstract int getCardNumber();
    abstract String getDescription();

    public File getFile(){
        return operationFiler.getFile();
    }

    public rUBERn.Job getJob() {
        return job;
    }

    public double getAmount() {
        return amount;
    }
    public String getAmountAsString() {
        return String.format("%.2f", this.amount);
    }
}
