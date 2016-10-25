package rUBERn.GUI;

import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by facundo on 10/25/16.
 */
public class DriverMenu{
    private Stage primaryStage;
    public DriverMenu(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public Scene getScene() {
        Text title = new Text("Driver Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane driverMenu = new GridPane();
        driverMenu.setAlignment(Pos.CENTER);
        driverMenu.setHgap(100);
        driverMenu.setVgap(100);
        driverMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("add Driver");
        add.setOnAction(event -> System.out.println("Metodo que vamos a implementar despeus"));
        add.setAlignment(Pos.CENTER_LEFT);

        Button toggleOnline = new Button();
        toggleOnline.setText("Client Options");
        toggleOnline.setAlignment(Pos.CENTER);
        toggleOnline.setOnAction(event -> System.out.println("Metodo que ponga al chofer seleccionado (en una lista que aparezca en esta escena) online/offline"));

        Button quit = new Button();
        quit.setText("Back");
        quit.setAlignment(Pos.CENTER_RIGHT);
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage).getScene()));

        driverMenu.add(title, 0, 0);
        driverMenu.add(add, 0, 1);
        driverMenu.add(toggleOnline, 1, 1);
        driverMenu.add(quit, 2, 1);


        return new Scene(driverMenu, 600, 400);

    }
}
