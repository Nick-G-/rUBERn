package rUBERn.GI;

// Created by nico on 11/2/16.

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

public class Camera {
    Input input;
    Vector2f cameraPos;

    public Camera (Input input) {
        this.input = input;
        this.cameraPos = new Vector2f(0,0);
    }

    public void handleInput(int delta) {
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
    }

    public Vector2f getCameraPos() {
        return cameraPos;
    }
}
