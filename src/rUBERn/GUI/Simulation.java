package rUBERn.GUI;

// Created by nico on 10/23/16.

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import rUBERn.Rubern;

public class Simulation implements Runnable{
    private boolean isRunning = false;
    private Thread thread;

    private String title;
    private int width, height;

    private Rubern rUBERn;
    private GraphicsContext gc;
    private Stage stage;
    private Group group;
    private Canvas canvas;
    private Scene scene;

    public Simulation(Rubern rUBERn, Stage stage) {
        this.rUBERn = rUBERn;
        this.stage = stage;
        this.group = new Group();
        this.canvas = new Canvas(1200, 600);
        this.gc = canvas.getGraphicsContext2D();
        this.scene = new Scene(group, 1200, 600, Color.AZURE);
        run();
    }

    private void init() {
        gc.setFill(Color.AZURE);
        gc.fillRect(0,0,1200,600);
        gc.setFill(Color.CORNFLOWERBLUE);
        isRunning = true;

    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps; // 1 second / FPS (in nanoseconds)
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        long timer = 0;
        int ticks = 0;

        while(isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now -lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                ticks++;
                render();

                delta --;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and renders last second: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    public void tick() {

    }

    public void render() {
        gc.fillRect(10,10,100,100);
        stage.setScene(scene);
    }

    public synchronized void start() {
        if (isRunning)
            return;

        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
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
