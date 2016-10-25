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
public class MainMenu {
    private Stage primaryStage;
    private Rubern ruben;
    public MainMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
    }
    public Scene getScene() {
        Text title = new Text("rUBERn");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane mainMenu = new GridPane();
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setHgap(100);
        mainMenu.setVgap(100);
        mainMenu.setPadding(new Insets(25, 25, 25, 25));

        Button driver = new Button();
        driver.setText("Driver Options");
        driver.setOnAction(event -> primaryStage.setScene(new DriverMenu(primaryStage, ruben).getScene()));
        Button client = new Button();

        client.setText("Client Options");
        client.setOnAction(event -> primaryStage.setScene(new ClientMenu(primaryStage, ruben).getScene()));

        Button quit = new Button();
        quit.setText("Quit");
        quit.setOnAction(event -> System.exit(0));

        mainMenu.add(title, 0, 0);
        mainMenu.add(driver, 0, 1);
        mainMenu.add(client, 1, 1);
        mainMenu.add(quit, 2, 1);


        return new Scene(mainMenu, 1200, 600);

    }
}
