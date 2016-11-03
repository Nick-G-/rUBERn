package rUBERn.DriverStatus;

import rUBERn.Job;

/**
 * Created by facundo on 10/21/16.
 */
public interface Status {
    void goOnline();
    void goOffline();
    void goWorking();

    void receiveJob(Job job);

    boolean isAvailableForJob();
    boolean isWorking();
    boolean isOnline();
    String toString();
}
