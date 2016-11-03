package rUBERn.GI;

// Created by nico on 10/31/16.

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import rUBERn.Driver;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Location;
import rUBERn.Rubern;

public class DriverCreator extends PersonCreator {

    public DriverCreator (SimulationState sim, Input input, Graphics g, Rubern rUBERn) {
        super(sim, input, g, rUBERn);
    }

    @Override
    public void handleInput() {
        if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
            Driver newDriver = new Driver("created", new Location(sim.getMousePosWorld()), rUBERn);
            rUBERn.addDriver(newDriver);

            newDriver.goOnline();

        }
    }

    @Override
    void render() {
        g.drawString("Click to create driver", sim.getMousePosWorld().getX()+15, sim.getMousePosWorld().getY()+15);
    }

    @Override
    String getName() {
        return "Driver Creator";
    }
}
