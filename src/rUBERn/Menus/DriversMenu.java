package rUBERn.Menus;

// Created by nico on 10/23/16.

import rUBERn.Driver;

public class DriversMenu extends OptionsMenu{

    public DriversMenu(String title, String... options) {
        super(title, options);
    }

    public DriversMenu() {
        super("Drivers Menu", "List Drivers", "Go");

    }
    @Override
    public void drawTitle() {

    }

    @Override
    public void drawContent() {

    }

    @Override
    public void processInput() {
        switch (scanner.nextInt()) {
            case 1:
                listDrivers();
            case 2:

        }
    }

    @Override
    public void goBack() {

    }

    private void listDrivers() {
        for (Driver driver : rubern.getDriverAgent().getDrivers())
            System.out.println(driver.toString());
    }

}
