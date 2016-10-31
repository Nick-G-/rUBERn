package rUBERn.GUI;

// Created by nico on 10/23/16.

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sim extends Application implements Runnable{
    public static void main(String[] args) { launch(args); }



    String title;
    int width, height;

    private Thread thread;
    private boolean isRunning = false;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("rUBERn");

        Group group = new Group();
        Scene scene = new Scene(group, 300, 300, Color.AZURE);

        stage.setScene(scene);
        stage.show();

        startSim();
    }

    private void initialize() {
    }
    private void tick() {

    }
    private void render() {

    }
    @Override
    public void run() {

        initialize();

        while(isRunning) {
            tick();
            System.out.println("just ticked");
            render();
        }

        stopSim();
    }

    public synchronized void startSim() {
        if (isRunning)
            return;

        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stopSim() {
        if (!isRunning)
            return;

        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
