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

    @Override
    public int getID() {
        return States.GAME;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        cameraPos = new Vector2f(0,0);
        rUBERn = new Rubern();
        menuPos = new Vector2f();
        menuBorder = new Circle(0,0,300,8);
        menuSplit = new Line(300,300,300,500);

        Driver dan = new Driver("dan", rUBERn);
        Driver daniel = new Driver("daniel", rUBERn);
        try {
            dan.goOnline();
            daniel.goOnline();
        } catch (AlreadyInStatusException e) {
            e.printStackTrace();
        }
        dan.moveTo(new Location(0,0));
        dan.addToSorter();
        daniel.moveTo(new Location(30,30));
        daniel.addToSorter();
        Client clinton = new Client("clinton", new Location(200,200));
        rUBERn.addClient(clinton);
        clinton.request(new Location(100, 100), rUBERn);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        Input input = gc.getInput();

        g.translate(cameraPos.getX(), cameraPos.getY());

        g.drawString("SimulationState here.", 500, 50);
        g.draw(new Circle(x,y,10,6));

        g.drawString(getMousePosCamera(gc).toString(),100,100);
        g.drawString(getMousePosWorld(gc).toString(),100,150);

        // <-- Draw Drivers -->
        for (Driver driver : rUBERn.getDriverAgent().getDrivers()) {
            g.draw(new Circle(driver.getCurrentLocation().getX(),driver.getCurrentLocation().getY(), 10, 4));
            if (driver.getStatus().isWorking())
                g.draw(new Line(driver.getCurrentLocation().toVector2f(), driver.getCurrentDestination().toVector2f()));
        }

        // <-- Draw Clients -->
        for (Client client : rUBERn.getClients()) {
            g.draw(new Circle(client.getCurrentLocation().getX(), client.getCurrentLocation().getY(), 10, 8));
        }

        if (input.isMousePressed(1)) {
            menuPos.set(getMousePosCamera(gc));
            menuBorder.setCenterX(getMousePosCamera(gc).getX());
            menuBorder.setCenterY(getMousePosCamera(gc).getY());
            menuSplit.set(menuBorder.getCenterX(), menuBorder.getMaxY(), menuBorder.getCenterX(), menuBorder.getMaxY());
        }
        if (input.isMouseButtonDown(1)) {
            g.draw(menuBorder);
            g.draw(menuSplit);
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

    }

    private Vector2f getMousePosCamera(GameContainer gc) {
        return new Vector2f(Mouse.getX(), gc.getHeight()-1-Mouse.getY());
    }
    private Vector2f getMousePosWorld(GameContainer gc){
        return new Vector2f(Mouse.getX()-cameraPos.getX(), gc.getHeight()-1-Mouse.getY()-cameraPos.getY());
    }

    private void checkForCameraMovement() {

    }
}
