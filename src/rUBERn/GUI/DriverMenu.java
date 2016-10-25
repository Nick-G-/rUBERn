package rUBERn.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rUBERn.Driver;
import rUBERn.Rubern;
import javafx.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        list = new ListView<Driver>();
        ObservableList<Driver> drivers = FXCollections.observableArrayList();
        for (int i=0; i< ruben.getDrivers().size(); i++){
            drivers.add(ruben.getDrivers().get(i));
        }
        list.setItems(drivers);

        Text title = new Text("Driver Options");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        Text description = new Text("Driver Details");
        EventHandler ev = list.getOnMouseClicked();
        list.setOnMouseClicked(mouseEvent -> description.setText(list.getSelectionModel().getSelectedItem().getName() +
                "\n" + list.getSelectionModel().getSelectedItem().getStatus() +
                "\n" + list.getSelectionModel().getSelectedItem().getCreditCardNumber()));


        GridPane driverMenu = new GridPane();
        driverMenu.setHgap(100);
        driverMenu.setVgap(100);
        driverMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("add Driver");
        add.setOnAction(event -> primaryStage.setScene(new DriverAddMenu(primaryStage,drivers, ruben).getScene()));

        Button toggleOnline = new Button();
        toggleOnline.setText("go online");
        toggleOnline.setOnAction(event ->list.getSelectionModel().getSelectedItem().goOnline());

        Button toggleOffline = new Button();
        toggleOffline.setText("go offline");
        toggleOffline.setOnAction(event ->list.getSelectionModel().getSelectedItem().goOffline());

        Button quit = new Button();
        quit.setText("Back");
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage, ruben).getScene()));


        driverMenu.add(title, 0, 0);
        driverMenu.add(list, 0, 1);
        driverMenu.add(description, 1, 1);
        driverMenu.add(add, 2, 0);
        driverMenu.add(toggleOnline, 2, 1);
        driverMenu.add(toggleOffline, 2, 2);
        driverMenu.add(quit, 2, 3);
        return new Scene(driverMenu, 1200, 600);
    }
}
