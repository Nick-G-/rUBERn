package rUBERn.GUI;/**
 * Created by arimi on 21-Oct-16.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import rUBERn.Rubern;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        Rubern ruben = new Rubern();
        MainMenu main = new MainMenu(primaryStage, ruben);
        primaryStage.setTitle("rUBERn");
        primaryStage.setScene(main.getScene());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}