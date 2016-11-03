package rUBERn.GI;

// Created by nico on 10/31/16.

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;
import rUBERn.Client;
import rUBERn.Location;
import rUBERn.Rubern;

public class ClientCreator extends PersonCreator{
    Vector2f leftButtonPressedPosition;
    Vector2f leftButtonReleasedPosition;
    private boolean leftButtonDownFlag = false;
    private FakeNames fakeNames = new FakeNames();

    Client newClient;

    public ClientCreator (SimulationState sim, Input input, Graphics g, Rubern rUBERn) {
        super(sim, input, g, rUBERn);
    }

    @Override
    void handleInput() {
        if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
            leftButtonPressedPosition = sim.getMousePosWorld();
            newClient = new Client(fakeNames.getRandom(), new Location(leftButtonPressedPosition));
            rUBERn.addClient(newClient);

        }

        if (!(input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)) & leftButtonDownFlag) {
            leftButtonReleasedPosition = sim.getMousePosWorld();
            newClient.request(new Location(leftButtonReleasedPosition), rUBERn);

            leftButtonDownFlag = false;
        }

        if (input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)) {
            leftButtonDownFlag = true;
        }

    }

    @Override
    void render() {
        if (input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)) {
            g.draw(new Line(leftButtonPressedPosition, sim.getMousePosWorld()));
        } else {
            g.drawString("Click to create client, drag to destination.", sim.getMousePosWorld().getX() + 15, sim.getMousePosWorld().getY() + 15);
        }
    }

    @Override
    String getName() {
        return "Client Creator";
    }
}
