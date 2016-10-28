package rUBERn.GUI;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import rUBERn.*;

/**
 * Created by facundo on 10/25/16.
 */
public class ClientAddMenu {
    private Stage primaryStage;
    private Rubern ruben;
    private ClientMenu previousMenu;
    public ClientAddMenu(Stage primaryStage, Rubern ruben, ClientMenu previousMenu){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
        this.previousMenu = previousMenu;
    }
    public Scene getScene(){
        Text title = new Text("Add a Client");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane clientAddMenu = new GridPane();
        clientAddMenu.setHgap(20);
        clientAddMenu.setVgap(20);
        clientAddMenu.setPadding(new Insets(25, 25, 25, 25));

        Text y = new Text("Location Y");
        y.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        Text x = new Text("Location X");
        x.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        Text warningText = new Text();
        Text name = new Text("Client name");
        name.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        TextField nameField = new TextField();

        TextField locationx = new TextField();
        final TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        locationx.setTextFormatter(formatter);
        TextField locationy = new TextField();
        final TextFormatter<Integer> formatter2 = new TextFormatter<>(new IntegerStringConverter());
        locationy.setTextFormatter(formatter2);

        LongStringConverter converter = new LongStringConverter();

        Button add = new Button();
        add.setText("Add");
        add.setOnAction(event -> {
            if (!locationx.getText().equals("") & !nameField.getText().equals("") & !locationy.getText().equals("")){
                ruben.addClient(new Client(new CreditCard(), new Location(converter.fromString(locationx.getText()), converter.fromString(locationy.getText())), nameField.getText()));
                warningText.setText("Client added successfully");
            } else warningText.setText("Please fill out all the fields before adding");
        });


        Button back = new Button();
        back.setText("Back");
        back.setOnAction(event -> primaryStage.setScene(previousMenu.getScene()));

        clientAddMenu.add(title, 0, 0);
        clientAddMenu.add(add, 0, 1);
        clientAddMenu.add(warningText,2,2);
        clientAddMenu.add(name,1,0);
        clientAddMenu.add(nameField,1,1);
        clientAddMenu.add(x,1,2);
        clientAddMenu.add(locationx,1,3);
        clientAddMenu.add(y,1,4);
        clientAddMenu.add(locationy,1,5);

        clientAddMenu.add(back, 2, 1);
        return new Scene(clientAddMenu, 1200, 600);
    }
}

