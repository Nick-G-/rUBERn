package rUBERn.GUI;/**
 * Created by arimi on 21-Oct-16.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainMenu main = new MainMenu(primaryStage);
        primaryStage.setTitle("rUBERn");
        primaryStage.setScene(main.getScene());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}