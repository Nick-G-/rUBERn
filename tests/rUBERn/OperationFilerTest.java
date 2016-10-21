package rUBERn;

import org.junit.Test;
import rUBERn.Operations.ChargeOperation;
import rUBERn.Operations.Operation;
import rUBERn.Operations.PayOperation;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by arimi on 20-Oct-16.
 */
public class OperationFilerTest {
    @Test
    public void writeOperation() throws Exception {
        Rubern rubern = new Rubern();
        Driver dan = new Driver("Dan",rubern);
        Client clinton = new Client("Clinton");
        Journey journey = new Journey(clinton);

        Job job = new Job(dan, clinton, journey);

        PayOperation payment = new PayOperation(job, 300);
        ChargeOperation charge = new ChargeOperation(job, 300);

        assertEquals(true,payment.getFile().exists());
        assertEquals(true,charge.getFile().exists());
    }

}