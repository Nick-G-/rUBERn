package rUBERn.GUI;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
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
import rUBERn.*;

import javax.swing.*;

/**
 * Created by facundo on 10/25/16.
 */
public class DriverAddMenu {
    private ObservableList<Driver> list;
    private Stage primaryStage;
    private Rubern ruben;

    public DriverAddMenu(Stage primaryStage, ObservableList<Driver> list, Rubern ruben){
        this.primaryStage = primaryStage;
        this.list = list;
        this.ruben = ruben;
    }
    public Scene getScene(){
        Text title = new Text("Add a driver");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        GridPane driverAddMenu = new GridPane();
        driverAddMenu.setHgap(20);
        driverAddMenu.setVgap(20);
        driverAddMenu.setPadding(new Insets(25, 25, 25, 25));

        Text y = new Text("Location Y");
        y.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        Text x = new Text("Location X");
        x.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        Text capacityText = new Text("Car Capacity");
        capacityText.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        TextField name = new TextField("Driver Name");
        TextField locationx = new TextField();
        final TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        locationx.setTextFormatter(formatter);
        TextField locationy = new TextField();
        final TextFormatter<Integer> formatter2 = new TextFormatter<>(new IntegerStringConverter());
        locationy.setTextFormatter(formatter2);
        TextField capacity = new TextField();
        final TextFormatter<Integer> formatter3 = new TextFormatter<>(new IntegerStringConverter());
        capacity.setTextFormatter(formatter3);
        TextField category = new TextField("Car category");
        Button add = new Button();
        add.setText("Add");
        add.setOnAction(event -> ruben.addDriver(new Driver(new CreditCard(), new Location(Integer.parseInt(locationx.getText()), Integer.parseInt(locationy.getText())),name.getText(),
                new Car(Integer.parseInt(capacity.getText()), category.getText()), ruben )));


        Button back = new Button();
        back.setText("Back");
        back.setOnAction(event -> primaryStage.setScene(new DriverMenu(primaryStage, ruben).getScene()));

        driverAddMenu.add(title, 0, 0);
        driverAddMenu.add(add, 0, 1);

        driverAddMenu.add(name ,1,0);
        driverAddMenu.add(x,1,1);
        driverAddMenu.add(locationx,1,2);
        driverAddMenu.add(y,1,3);
        driverAddMenu.add(locationy,1,4);
        driverAddMenu.add(capacityText,1,5);
        driverAddMenu.add(capacity ,1,6);
        driverAddMenu.add(category ,1,7);

        driverAddMenu.add(back, 2, 1);
        return new Scene(driverAddMenu, 1200, 600);
    }
}

