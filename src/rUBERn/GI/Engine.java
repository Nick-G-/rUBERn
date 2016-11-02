package rUBERn.GI;

// Created by nico on 10/29/16.

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import rUBERn.Rubern;


public class Engine extends StateBasedGame{
   public static Rubern rubern;
    public static AppGameContainer game;
    public static void main(String[] args){
        try {
            game = new AppGameContainer(new Engine());
            game.setDisplayMode(1200, 600, false);
            game.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Engine() {
        super("rUBERn");
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.getGraphics().resetFont();
        gc.setMaximumLogicUpdateInterval(Settings.UPS);
        gc.setVSync(true);
        gc.setTargetFrameRate(Settings.UPS);

        this.addState(new SimulationState(rubern));
        this.addState(new MenuState());
    }
}