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
import rUBERn.Driver;
import rUBERn.Exceptions.InvalidStatusChangeException;
import rUBERn.Rubern;
import javafx.event.*;

/**
 * Created by facundo on 10/25/16.
 */
public class DriverMenu{
    private Stage primaryStage;
    private Rubern ruben;
    private ListView<Driver> list;
    public DriverMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.ruben = ruben;

    }
    public Scene getScene() {
        list = new ListView<>();
        ObservableList<Driver> drivers =  FXCollections.observableArrayList();
        drivers.addAll(ruben.getDrivers());
        if (list.getItems().isEmpty())
            list.setItems(drivers);
        Text warningText = new Text();
        Text title = new Text("Driver Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        Text description = new Text("Driver Details");
        EventHandler onListClicked = list.getOnMouseClicked();
        list.setOnMouseClicked(mouseEvent -> description.setText(list.getSelectionModel().getSelectedItem().getName() +
                "\n" + list.getSelectionModel().getSelectedItem().getStatus() +
                "\n" + list.getSelectionModel().getSelectedItem().getCreditCardNumber()));


        GridPane driverMenu = new GridPane();
        driverMenu.setHgap(100);
        driverMenu.setVgap(100);
        driverMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("add Driver");
        add.setOnAction(event -> primaryStage.setScene(new DriverAddMenu(primaryStage, ruben).getScene()));

        Button toggleOnline = new Button();
        toggleOnline.setText("go online");
        toggleOnline.setOnAction(event -> {
            try {
                if (list.getSelectionModel().getSelectedItem() != null) {
                    list.getSelectionModel().getSelectedItem().goOnline();
                } else warningText.setText("Please select a driver");
            }catch (InvalidStatusChangeException e) {
                warningText.setText("Driver Aleready online or offline");
            }
        });

        Button toggleOffline = new Button();
        toggleOffline.setText("go offline");
        toggleOffline.setOnAction(event -> {
            try {
                if (list.getSelectionModel().getSelectedItem() != null) {
                    list.getSelectionModel().getSelectedItem().goOffline();
                } else warningText.setText("Please select a driver");
            }catch (InvalidStatusChangeException e) {
                warningText.setText("Driver Already online or offline");
            }
        });

        Button quit = new Button();
        quit.setText("Back");
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage, ruben).getScene()));


        driverMenu.add(title, 0, 0);
        driverMenu.add(list, 0, 1);
        driverMenu.add(description, 1, 1);
        driverMenu.add(add, 0, 2);
        driverMenu.add(warningText,0,3);
        driverMenu.add(toggleOnline, 1, 2);
        driverMenu.add(toggleOffline, 2, 2);
        driverMenu.add(quit, 3, 2);
        return new Scene(driverMenu, 1200, 600);
    }
}
