package rUBERn.Operations;

// Created by nico on 10/1/16.

//import java.io.IOException;
import rUBERn.rUBERn.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class Operation {
    private UUID id;
    private Instant instant;
    private rUBERn.Job job;
    private double amount;
    //private OperationsFiler operationsFiler = new OperationsFiler();
    //private String operationData;

    public Operation(rUBERn.Job job, double amount) {
        this.id = UUID.randomUUID();
        this.instant = Instant.now();
        this.job = job;
        this.amount = amount;
        //this.operationData = toArchiveFormat();
        //this.operationsFiler.FileOperation(operationData);
    }

    public String toArchiveFormat() {
        String id   = this.id.toString();
        String type = getType();
        String date = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(instant.atZone(ZoneId.systemDefault()));
        String time = DateTimeFormatter.ofPattern("HH:mm").format(instant.atZone(ZoneId.systemDefault()));
        String cardNumber       = String.valueOf(getCardNumber());
        String amountAsString   = this.getAmountAsString();
        String description      = getDescription();

        return  id          + "\n" +
                type        + "\n" +
                date        + "\n" +
                time        + "\n" +
                cardNumber  + "\n" +
                amountAsString + "\n" +
                description;
    }

    abstract String getType();
    abstract int getCardNumber();
    abstract String getDescription();

    public rUBERn.Job getJob() {
        return job;
    }

    public String getAmountAsString() {
        return String.format("%.2f", this.amount);
    }
}
