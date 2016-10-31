package rUBERn.GI;

// Created by nico on 10/29/16.

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import rUBERn.*;
import rUBERn.Exceptions.AlreadyInStatusException;

public class SimulationState extends BasicGameState {

    private Rubern rUBERn;
    private DriverAgent driverAgent;
    private float x=100,y=100;
    private Vector2f cameraPos;
    private Vector2f menuPos;
    private Vector2f menuTopPoint;
    private Vector2f menuBotPoint;
    private Circle menuBorder;
    private Line menuSplit;
    boolean downFlagRight = false;
    boolean downFlagLeft = false;
    private Vector2f rightButtonReleasedPosition;
    private boolean driverCreatorSelected = true;
    private Vector2f leftButtonReleasedPosition;
    private Vector2f leftButtonPressedPosition;
    Client newClient;

    @Override
    public int getID() {
        return States.GAME;
    }
    public SimulationState(Rubern ruben){
        this.rUBERn = ruben;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        cameraPos = new Vector2f(0,0);
        rightButtonReleasedPosition = new Vector2f(0,0);
      //  rUBERn = new Rubern();
        menuPos = new Vector2f();
        menuBorder = new Circle(0,0,100,12);
        menuSplit = new Line(0,0,0,0);


        Driver dan = new Driver("dan", rUBERn);
        Driver daniel = new Driver("daniel", rUBERn);
        try {
            dan.goOnline();
            daniel.goOnline();
        } catch (AlreadyInStatusException e) {
            e.printStackTrace();
        }
        dan.moveTo(new Location(400,400));
        dan.addToSorter();

        daniel.moveTo(new Location(500,500));
        daniel.addToSorter();

        Client clinton = new Client("clinton", new Location(200,200));
        rUBERn.addClient(clinton);

        clinton.request(new Location(100, 300), rUBERn);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {



        Input input = gc.getInput();

        g.translate(cameraPos.getX(), cameraPos.getY());


            g.drawString("SimulationState here.", 500, 50);
            //g.draw(new Circle(x, y, 10, 6));

            g.drawString("Mouse relative to camera: " + getMousePosCamera(gc).toString().substring(9), 100, 100);
            g.drawString("Mouse relative to world:  " + getMousePosWorld(gc).toString().substring(9), 100, 120);
            g.drawString(driverCreatorSelected ? "Drivers" : "Clients", 1000, 100);

            // <-- Draw Drivers -->
            for (Driver driver : rUBERn.getDriverAgent().getDrivers()) {
                if (driver.getStatus().isOnline()) {
                    g.draw(new Circle(driver.getCurrentLocation().getX(), driver.getCurrentLocation().getY(), 10, 4));

                    if (driver.getStatus().isWorking())
                        g.draw(new Line(driver.getCurrentLocation().toVector2f(), driver.getCurrentDestination().toVector2f()));
                }
            }

            // <-- Draw Clients -->
            for (Client client : rUBERn.getClients()) {
                g.draw(new Circle(client.getCurrentLocation().getX(), client.getCurrentLocation().getY(), 10, 8));
                if (client.isWaiting()) {
                }
            }

            // <-- Selection Menu -->
            if (input.isMousePressed(input.MOUSE_RIGHT_BUTTON)) {
                menuPos.set(getMousePosCamera(gc));
                menuBorder.setCenterX(getMousePosWorld(gc).getX());
                menuBorder.setCenterY(getMousePosWorld(gc).getY());
                menuSplit.set(menuBorder.getCenterX(), menuBorder.getMaxY(), menuBorder.getCenterX(), menuBorder.getMinY());
            }
            if (input.isMouseButtonDown(input.MOUSE_RIGHT_BUTTON)) {
                g.draw(menuBorder);
                g.draw(menuSplit);
                downFlagRight = true;
            }

            if (!input.isMouseButtonDown(input.MOUSE_RIGHT_BUTTON) && downFlagRight) {
                downFlagRight = false;
                rightButtonReleasedPosition = getMousePosWorld(gc);
                if (rightButtonReleasedPosition.getX() < menuBorder.getCenterX()) {
                    driverCreatorSelected = true;
                } else {
                    driverCreatorSelected = false;
                }
            }

            // <-- Creator -->

            if (driverCreatorSelected) {
                if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
                    Driver newDriver = new Driver("created", new Location(getMousePosWorld(gc)), rUBERn);
                    rUBERn.addDriver(newDriver);
                    try {
                        newDriver.goOnline();
                    } catch (AlreadyInStatusException e) {
                        e.printStackTrace();
                    }
                }
            }


            if (!driverCreatorSelected) {

                if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
                    leftButtonPressedPosition = getMousePosWorld(gc);
                    newClient = new Client("created", new Location(getMousePosWorld(gc)));
                    rUBERn.addClient(newClient);

                }

                if (!(input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)) && downFlagLeft) {
                    leftButtonReleasedPosition = getMousePosWorld(gc);
                    newClient.request(new Location(leftButtonReleasedPosition), rUBERn);
                }

                if (input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)) {
                    downFlagLeft = true;
                    g.draw(new Line(leftButtonPressedPosition, getMousePosWorld(gc)));
                }


            }

        }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

        for (Driver driver : rUBERn.getDriverAgent().getDriversWorking()) {
            driver.work(delta);
        }
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            s.enterState(States.MENU);
        }



        // <-- Camera Movement -->

        if (input.isKeyDown(input.KEY_RIGHT)) {
            cameraPos.x -= delta*Settings.CAMERA_SPEED;
        }
        if (input.isKeyDown(input.KEY_LEFT)) {
            cameraPos.x += delta*Settings.CAMERA_SPEED;
        }
        if (input.isKeyDown(input.KEY_UP)) {
            cameraPos.y += delta*Settings.CAMERA_SPEED;
        }
        if (input.isKeyDown(input.KEY_DOWN)) {
            cameraPos.y -= delta*Settings.CAMERA_SPEED;
        }
        x++;
        y++;
        if (input.isKeyDown(input.KEY_ESCAPE)){
            throw new SlickException("Close");
        }

    }

    private Vector2f getMousePosCamera(GameContainer gc) {
        return new Vector2f(Mouse.getX(), gc.getHeight()-1-Mouse.getY());
    }
    private Vector2f getMousePosWorld(GameContainer gc){
        return new Vector2f(Mouse.getX()-cameraPos.getX(), gc.getHeight()-1-Mouse.getY()-cameraPos.getY());
    }
}
