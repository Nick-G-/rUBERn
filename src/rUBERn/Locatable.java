package rUBERn;

// Created by nico on 10/2/16.

import javafx.geometry.Point2D;
import org.newdawn.slick.geom.Vector2f;

public interface Locatable {
    Location getCurrentLocation();
    Vector2f getCurrentLocationAsVector2f();
}
