package rUBERn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arimi on 20-Oct-16.
 */
public class OperationsFilerTest {
    @Test
    public void writeOperation() throws Exception {
        Driver dan = new Driver("Dan");
        Client clinton = new Client("Clinton");
        Journey journey = new Journey(clinton);

        Job job = new Job(dan, clinton, journey);

        PayOperation payment = new PayOperation(job, 300);
        ChargeOperation charge = new ChargeOperation(job, 300);

    }

}