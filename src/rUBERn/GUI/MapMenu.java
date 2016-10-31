package rUBERn.GUI;

// Created by nico on 10/26/16.

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import rUBERn.Driver;
import rUBERn.Rubern;

public class MapMenu {
    private Stage primaryStage;
    private Rubern rUBERn;
    private ListView<Driver> list;

    public MapMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.rUBERn = ruben;
    }

    public Scene getScene() {
        Group group = new Group();
        Canvas canvas = new Canvas(1200,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Simulation sim = new Simulation(rUBERn, primaryStage);
        return new Scene(group, 1200, 600, Color.AZURE);
    }
}
