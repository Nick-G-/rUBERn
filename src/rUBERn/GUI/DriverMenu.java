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
import rUBERn.Rubern;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

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

        GridPane driverMenu = new GridPane();
        driverMenu.setHgap(100);
        driverMenu.setVgap(100);
        driverMenu.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button();
        add.setText("add Driver");
        add.setOnAction(event -> addDriver(drivers));
        Button toggleOnline = new Button();
        toggleOnline.setText("Toggle Online/Offline");
        toggleOnline.setOnAction(event -> System.out.println("Metodo que ponga al chofer seleccionado (en una lista que aparezca en esta escena) online/offline"));

        Button quit = new Button();
        quit.setText("Back");
        quit.setOnAction(event -> primaryStage.setScene(new MainMenu(primaryStage, ruben).getScene()));

        driverMenu.add(title, 0, 0);
        driverMenu.add(add, 0, 1);
        driverMenu.add(toggleOnline, 1, 1);
        driverMenu.add(quit, 2, 1);
        driverMenu.add(list, 0, 0);


        return new Scene(driverMenu, 1200, 600);

    }

    private void addDriver(ObservableList drivers) {
        Driver driver = new Driver("Ronaldo",ruben);
        ruben.addDriver(driver);
        drivers.add(driver);


    }
}
