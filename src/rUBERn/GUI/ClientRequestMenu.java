package rUBERn.GUI;

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
import rUBERn.Client;
import rUBERn.Exceptions.DriverNotFoundException;
import rUBERn.Location;
import rUBERn.Rubern;

/**
 * Created by facundo on 10/26/16.
 */
public class ClientRequestMenu {
    private Stage primaryStage;
    private Client client;
    private Rubern ruben;
    private ClientMenu previousMenu;

    public ClientRequestMenu(Stage primaryStage, Client client, Rubern ruben, ClientMenu previousMenu) {
        this.primaryStage = primaryStage;
        this.client = client;
        this.ruben = ruben;
        this.previousMenu = previousMenu;
    }
    public Scene getScene(){
        Text title = new Text("Request Trip");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane clientAddMenu = new GridPane();
        clientAddMenu.setHgap(20);
        clientAddMenu.setVgap(20);
        clientAddMenu.setPadding(new Insets(25, 25, 25, 25));

        Text y = new Text("Location Y");
        y.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        Text x = new Text("Location X");
        x.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        Text warningText = new Text();

        TextField locationx = new TextField();
        final TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        locationx.setTextFormatter(formatter);
        TextField locationy = new TextField();
        final TextFormatter<Integer> formatter2 = new TextFormatter<>(new IntegerStringConverter());
        locationy.setTextFormatter(formatter2);
        LongStringConverter converter = new LongStringConverter();

        Button request = new Button();
        request.setText("Request");
        request.setOnAction(event -> {
            if (!locationx.getText().equals("") & !locationy.getText().equals("")){
                try {
                    client.request(new Location(converter.fromString(locationx.getText()), converter.fromString(locationy.getText())), ruben);
                    warningText.setText("Request done successfully");
                }catch (DriverNotFoundException e){
                    warningText.setText("No drivers avaliable, Please try again later");
                }
            }else warningText.setText("Please fill out all fields");
        });


        Button back = new Button();
        back.setText("Back");
        back.setOnAction(event -> primaryStage.setScene(previousMenu.getScene()));

        clientAddMenu.add(title, 0, 0);
        clientAddMenu.add(request, 0, 1);
        clientAddMenu.add(warningText,2,2);
        clientAddMenu.add(x,1,1);
        clientAddMenu.add(locationx,1,2);
        clientAddMenu.add(y,1,3);
        clientAddMenu.add(locationy,1,4);

        clientAddMenu.add(back, 2, 1);
        return new Scene(clientAddMenu, 1200, 600);
    }
}
