package rUBERn.GI;

// Created by nico on 10/29/16.

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import rUBERn.Rubern;


public class Engine extends StateBasedGame{
    public static Rubern rubern;
    public static void main(String[] args) {
        try {
            AppGameContainer game = new AppGameContainer(new Engine());
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
        gc.setMaximumLogicUpdateInterval(Settings.UPS);
        gc.setVSync(true);
        gc.setTargetFrameRate(Settings.UPS);

        if (rubern == null) {
            this.addState(new SimulationState());
        }else {
            this.addState(new SimulationState(rubern));
        }
        this.addState(new MenuState());
    }
}