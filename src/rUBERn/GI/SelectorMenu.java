package rUBERn.GI;

// Created by nico on 10/31/16.

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;




public class SelectorMenu {
    private final Input input;
    private SimulationState sim;
    private Graphics g;

    private boolean rightButtonDownFlag;
    private Vector2f rightButtonReleasedPosition;

    private Vector2f position;
    private Circle border;
    private Line split;

    private Color colorAlpha = new Color(1f,1f,1f,0.5f);

    public SelectorMenu(SimulationState sim, Input input, Graphics g) {
        this.sim = sim;
        this.input = input;
        this.g = g;

        border = new Circle(40, 40, 100, 10);
        split = new Line(0,0,0,0);
        position = new Vector2f(0,0);
    }
    public void handleInput() {
        if (input.isMousePressed(input.MOUSE_RIGHT_BUTTON)) {
            position.set(sim.getMousePosCamera());
            border.setCenterX(sim.getMousePosWorld().getX());
            border.setCenterY(sim.getMousePosWorld().getY());
            split.set(border.getCenterX(), border.getMaxY(), border.getCenterX(), border.getMinY());
        }

        if (!input.isMouseButtonDown(input.MOUSE_RIGHT_BUTTON) && rightButtonDownFlag) {
            rightButtonDownFlag = false;
            rightButtonReleasedPosition = sim.getMousePosWorld();

            if (rightButtonReleasedPosition.getX() < border.getCenterX()) {
                sim.changeCurrentCreatorTo(sim.getDriverCreator());
            } else {
                sim.changeCurrentCreatorTo(sim.getClientCreator());
            }
        }
        if (input.isMouseButtonDown(input.MOUSE_RIGHT_BUTTON)) {
            rightButtonDownFlag = true;
        }
        if (input.isKeyDown(Input.KEY_A))
            sim.changeCurrentCreatorTo(sim.getDriverCreator());
        if (input.isKeyDown(Input.KEY_D))
            sim.changeCurrentCreatorTo(sim.getClientCreator());

    }
    public void render() {
        if (input.isMouseButtonDown(input.MOUSE_RIGHT_BUTTON)) {
            g.setColor(Color.black);
            g.fill(border);


            if(sim.getMousePosWorld().getX() < border.getCenterX()) {
                g.setColor(Color.cyan);
                g.drawString("Drivers\n  (a)", border.getCenterX() - 80, border.getCenterY() - 15);
                g.setColor(Color.white);
                g.drawString("Clients\n  (d)", border.getCenterX() + 10, border.getCenterY() - 15);
            } else {
                g.setColor(Color.green);
                g.drawString("Clients\n  (d)", border.getCenterX() + 10, border.getCenterY() - 15);
                g.setColor(Color.white);
                g.drawString("Drivers\n  (a)", border.getCenterX() - 80, border.getCenterY() - 15);
            }

            g.draw(border);
            g.draw(split);
        }
    }
}
