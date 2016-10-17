package rUBERn;

import org.junit.Test;

import static org.junit.Assert.*;


// Created by nico on 10/16/16.

public class OperationTest {
    @Test
    public void toArchiveFormat() {
        Driver dan = new Driver("Dan");
        Client clinton = new Client("Clinton");
        Journey journey = new Journey(clinton);

        Job job = new Job(dan, clinton, journey);

        PayOperation payment = new PayOperation(job, 300);
        ChargeOperation charge = new ChargeOperation(job, 300);

        System.out.println(payment.toArchiveFormat());
        System.out.println(charge.toArchiveFormat());
    }

}