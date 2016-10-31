package rUBERn.Menus;

// Created by nico on 10/28/16.

import rUBERn.Driver;

public class AddDriverMenu extends OptionsMenu{
    public AddDriverMenu() {
        super("Add Driver", "Custom", "Standard");
    }

    @Override
    public void processInput() {
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                createCustomDriver();
            case 2:
                createStandardDriver();
        }
    }

    @Override
    public void goBack() {

    }

    private void createCustomDriver() {
        System.out.println("Please input name");
        String name = scanner.nextLine();

        System.out.println("Please input location");
        System.out.println("x: ");
        Long x = scanner.nextLong();
        System.out.println("y: ");
        Long y = scanner.nextLong();

        System.out.println("Select car category");
    }

    private void createStandardDriver() {
        Driver driver = new Driver("dan", rubern);
    }
}
