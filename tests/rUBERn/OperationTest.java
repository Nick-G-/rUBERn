package rUBERn;

import org.junit.Assert;
import org.junit.Test;
import rUBERn.Operations.ChargeOperation;
import rUBERn.Operations.PayOperation;


// Created by nico on 10/16/16.

public class OperationTest {
    @Test
    public void toArchiveFormat() {
        Rubern rubern = new Rubern();
        Driver dan = new Driver("Dan", rubern);
        Client clinton = new Client("Clinton");
        Journey journey = new Journey(clinton);

        Job job = new Job(dan, clinton, journey);

        PayOperation payment = new PayOperation(job);
        ChargeOperation charge = new ChargeOperation(job);

        System.out.println(payment.toArchiveFormat());
        System.out.println(charge.toArchiveFormat());

    }

}