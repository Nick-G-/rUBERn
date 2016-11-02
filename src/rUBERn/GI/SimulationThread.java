package rUBERn.GI;

import rUBERn.GUI.ExitManager;

/**
 * Created by facundo on 11/2/16.
 */
public class SimulationThread implements Runnable {
    @Override
    public void run(){
        ExitManager sm = new ExitManager( System.getSecurityManager() );
        System.setSecurityManager(sm);
        try {
            Engine.main(null);
        }catch (SecurityException e){

           System.setSecurityManager(sm.getOriginalSecurityManager());
        }
    }
}
