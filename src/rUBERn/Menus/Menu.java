package rUBERn.Menus;

// Created by nico on 10/22/16.

import Utils.Scanner;
import rUBERn.Rubern;

public abstract class Menu {

    Scanner scanner = new Scanner();
    Rubern rubern = new Rubern();

    public void display() {
        clearScreen();
        drawTitle();
        drawLine();
        drawContent();
    }

    public void drawLine() {
        System.out.println("--- --- --- --- ---");
    }
    public void clearScreen() {
        for(int i=0;i<30;i++)
            System.out.println();
    }

    public abstract void drawTitle();
    public abstract void drawContent();
    public abstract void processInput();
    public abstract void goBack();

}
