package rUBERn.GI;

// Created by nico on 10/31/16.

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import rUBERn.Rubern;

public abstract class PersonCreator {
    protected final Input input;
    protected final Rubern rUBERn;
    protected final SimulationState sim;
    protected final Graphics g;

    public PersonCreator(SimulationState sim, Input input, Graphics g, Rubern rUBERn) {
        this.sim = sim;
        this.input = input;
        this.g = g;
        this.rUBERn = rUBERn;
    }

    abstract void handleInput();
    abstract void render();
    abstract String getName();
}
