package rUBERn.GI;

// Created by nico on 10/29/16.

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import rUBERn.Client;
import rUBERn.Driver;
import rUBERn.Rubern;

public class SimulationState extends BasicGameState {

    private Rubern rUBERn;
    private float x=100,y=100;

    private GameContainer gc;
    private Camera camera;
    private SelectorMenu selectorMenu;

    private DriverCreator driverCreator;
    private ClientCreator clientCreator;
    private PersonCreator currentCreator;

    public SimulationState() {
        this.rUBERn = new Rubern();
    }

    public SimulationState(Rubern rUBERn) {
        this.rUBERn = rUBERn;
    }
    @Override
    public int getID() {
        return States.SIMULATION;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        this.gc = gc;
        this.selectorMenu = new SelectorMenu(this, gc.getInput(), gc.getGraphics());
        this.driverCreator = new DriverCreator(this, gc.getInput(), gc.getGraphics(), rUBERn);
        this.clientCreator = new ClientCreator(this, gc.getInput(), gc.getGraphics(), rUBERn);
        this.currentCreator = driverCreator;

        camera = new Camera(gc.getInput());
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        Input input = gc.getInput();
        g.translate(camera.getCameraPos().getX(), camera.getCameraPos().getY());

        selectorMenu.render();
        currentCreator.render();

        drawInfo(g);
        drawClients(g);
        drawDrivers(g);
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

        camera.handleInput(delta);
        selectorMenu.handleInput();
        currentCreator.handleInput();


    }

    public Vector2f getMousePosCamera() {
        return new Vector2f(Mouse.getX(), gc.getHeight()-1-Mouse.getY());
    }
    public Vector2f getMousePosWorld(){
        return new Vector2f(Mouse.getX()-camera.getCameraPos().getX(), gc.getHeight()-1-Mouse.getY()-camera.getCameraPos().getY());
    }

    public DriverCreator getDriverCreator() {
        return driverCreator;
    }
    public ClientCreator getClientCreator() {
        return clientCreator;
    }
    public void changeCurrentCreatorTo(PersonCreator creator) {
        this.currentCreator = creator;
    }

    public void drawInfo(Graphics g) {
        g.drawString("SimulationState here.", 500, 50);
        //g.draw(new Circle(x, y, 10, 6));
        g.drawString("Mouse relative to camera: " + getMousePosCamera().toString().substring(9), 100, 100);
        g.drawString("Mouse relative to world:  " + getMousePosWorld().toString().substring(9), 100, 120);
        g.drawString("Earnings this run: $" + String.format("%.2f", rUBERn.getRealEarnings()), 700, 100);
        g.drawString(currentCreator.getName(), 700, 120);
    }
    public void drawDrivers(Graphics g) {
        g.setColor(Color.cyan);
        for (Driver driver : rUBERn.getDriverAgent().getDrivers()) {

            if (driver.getStatus().isOnline()) {
                g.draw(new Circle(driver.getCurrentLocation().getX(), driver.getCurrentLocation().getY(), 10, 4));

                if (driver.getStatus().isWorking())
                    g.draw(new Line(driver.getCurrentLocation().toVector2f(), driver.getCurrentDestination().toVector2f()));
            }
        }
        g.setColor(Color.white);
    }
    public void drawClients(Graphics g) {
        g.setColor(Color.green);

        for (Client client : rUBERn.getClients()) {


            if (client.isWaiting()) {
                g.draw(new Circle(client.getCurrentLocation().getX(), client.getCurrentLocation().getY(), 10, 8));
                g.draw(new Line(client.getCurrentLocation().toVector2f(), client.getCurrentDestination().toVector2f()));
            }
        }
        g.setColor(Color.white);
    }
}


