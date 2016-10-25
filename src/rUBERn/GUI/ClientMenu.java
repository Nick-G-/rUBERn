package rUBERn.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rUBERn.Rubern;

/**
 * Created by facundo on 10/25/16.
 */
public class ClientMenu {
    private Rubern ruben;
    private Stage primaryStage;
    public ClientMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
    }
    public Scene getScene() {
        Text title = new Text("Client Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane clientMenu = new GridPane();
        clientMenu.setHgap(100);
        clientMenu.setVgap(100);
        clientMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("Add client");
        add.setOnAction(event -> System.out.println("Metodo que vamos a implementar despeus"));

        Button requestTrip = new Button();
        requestTrip.setText("Request trip");
        requestTrip.setOnAction(event -> System.out.println("Metodo que arme el request (deberia saltar un popup con fields para llenar con los datos del trip)"));

        Button quit = new Button();
        quit.setText("Back");
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage, ruben).getScene()));

        clientMenu.add(title, 0, 0);
        clientMenu.add(add, 0, 1);
        clientMenu.add(requestTrip, 1, 1);
        clientMenu.add(quit, 2, 1);


        return new Scene(clientMenu, 1200, 600);

    }
}
