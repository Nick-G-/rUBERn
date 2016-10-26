package rUBERn.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rUBERn.Client;
import rUBERn.Rubern;

/**
 * Created by facundo on 10/25/16.
 */
public class ClientMenu {
    private Rubern ruben;
    private Stage primaryStage;
    private ListView<Client> list;
    private ObservableList<Client> clients;
    public ClientMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
        list = new ListView<>();
        clients = FXCollections.observableArrayList();
    }
    public ClientMenu(Stage primaryStage, Rubern ruben, ObservableList<Client> clients){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
        list = new ListView<>();
        this.clients = clients;
    }
    public Scene getScene() {

        list.setItems(clients);

        Text title = new Text("Client Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        Text warningText = new Text();
        GridPane clientMenu = new GridPane();
        clientMenu.setHgap(100);
        clientMenu.setVgap(100);
        clientMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("Add client");
        add.setOnAction(event -> primaryStage.setScene(new ClientAddMenu(primaryStage, clients, ruben,ClientMenu.this).getScene()));

        Button requestTrip = new Button();
        requestTrip.setText("Request trip");
        requestTrip.setOnAction(event -> {
            if (list.getSelectionModel().getSelectedItem() != null) {
                primaryStage.setScene(new ClientRequestMenu(primaryStage, list.getSelectionModel().getSelectedItem(), ruben, ClientMenu.this).getScene());
            }else
                warningText.setText("Please select a client from the list\nbefore requesting a trip");
        });

        Button quit = new Button();
        quit.setText("Back");
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage, ruben).getScene()));


        clientMenu.add(title, 0, 0);
        clientMenu.add(warningText, 1,1);
        clientMenu.add(list ,0 ,1);
        clientMenu.add(add, 0, 2);
        clientMenu.add(requestTrip, 1, 2);
        clientMenu.add(quit, 2, 2);


        return new Scene(clientMenu, 1200, 600);

    }
}
