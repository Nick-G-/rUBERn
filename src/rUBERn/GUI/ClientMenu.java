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

/**
 * Created by facundo on 10/25/16.
 */
public class ClientMenu {
    private Stage primaryStage;
    public ClientMenu(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public Scene getScene() {
        Text title = new Text("Client Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane clientMenu = new GridPane();
        clientMenu.setAlignment(Pos.CENTER);
        clientMenu.setHgap(100);
        clientMenu.setVgap(100);
        clientMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("add Client");
        add.setOnAction(event -> System.out.println("Metodo que vamos a implementar despeus"));
        add.setAlignment(Pos.CENTER_LEFT);

        Button requestTrip = new Button();
        requestTrip.setText("Client Options");
        requestTrip.setAlignment(Pos.CENTER);
        requestTrip.setOnAction(event -> System.out.println("Metodo que arme el request (deberia saltar un popup con fields para llenar con los datos del trip)"));

        Button quit = new Button();
        quit.setText("Back");
        quit.setAlignment(Pos.CENTER_RIGHT);
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage).getScene()));

        clientMenu.add(title, 0, 0);
        clientMenu.add(add, 0, 1);
        clientMenu.add(requestTrip, 1, 1);
        clientMenu.add(quit, 2, 1);


        return new Scene(clientMenu, 600, 400);

    }
}
