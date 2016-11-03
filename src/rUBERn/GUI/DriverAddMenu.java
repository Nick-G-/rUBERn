package rUBERn.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import rUBERn.*;
import rUBERn.Categories.Berreta;
import rUBERn.Categories.CarCategory;
import rUBERn.Categories.Deluxe;
import rUBERn.Categories.Standard;

/**
 * Created by facundo on 10/25/16.
 */
public class DriverAddMenu {
    private Stage primaryStage;
    private Rubern ruben;

    public DriverAddMenu(Stage primaryStage, Rubern ruben){
        this.primaryStage = primaryStage;
        this.ruben = ruben;
    }
    public Scene getScene(){
        Text title = new Text("Add a driver");
        title.setFont(Font.font("System Regular", 20));

        GridPane driverAddMenu = new GridPane();
        driverAddMenu.setHgap(20);
        driverAddMenu.setVgap(20);
        driverAddMenu.setPadding(new Insets(25, 25, 25, 25));

        Text y = new Text("Location Y");
        y.setFont(Font.font("System Regular", 14));
        Text x = new Text("Location X");
        x.setFont(Font.font("System Regular", 14));
        Text capacityText = new Text("Car Capacity");
        capacityText.setFont(Font.font("System Regular", 14));
        Text warningText = new Text();
        Text name = new Text("Driver name");
        name.setFont(Font.font("System Regular", 14));
        TextField nameField = new TextField("Driver Name");

        TextField locationx = new TextField();
        final TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        locationx.setTextFormatter(formatter);
        TextField locationy = new TextField();
        final TextFormatter<Integer> formatter2 = new TextFormatter<>(new IntegerStringConverter());
        locationy.setTextFormatter(formatter2);
        TextField capacity = new TextField();
        final TextFormatter<Integer> formatter3 = new TextFormatter<>(new IntegerStringConverter());
        capacity.setTextFormatter(formatter3);

        ListView<CarCategory> categoriesList = new ListView<>();
        ObservableList<CarCategory> categories = FXCollections.observableArrayList();
        categories.addAll(new Standard(), new Deluxe(), new Berreta());
        categoriesList.setItems(categories);

        LongStringConverter converter = new LongStringConverter();

        Button add = new Button();
        add.setText("Add");
        add.setOnAction(event -> {
            if (categoriesList.getSelectionModel().getSelectedItem() != null) {
                if (!locationx.getText().equals("") & !locationy.getText().equals("") & !capacity.getText().equals("")) {
                    addDriver(converter.fromString(locationx.getText()), converter.fromString(locationy.getText()), nameField.getText(), Integer.parseInt(capacity.getText()), categoriesList.getSelectionModel().getSelectedItem());
                    warningText.setText("Driver added successfully");
                }else warningText.setText("Please fill out all the fields before adding a driver");
            }else warningText.setText("You must select a car category before adding a driver");
        });


        Button back = new Button();
        back.setText("Back");
        back.setOnAction(event -> primaryStage.setScene(new DriverMenu(primaryStage, ruben).getScene()));

        driverAddMenu.add(title, 0, 0);
        driverAddMenu.add(add, 0, 1);
        driverAddMenu.add(warningText,2,2);
        driverAddMenu.add(name ,1,0);
        driverAddMenu.add(nameField ,1,1);
        driverAddMenu.add(x,1,2);
        driverAddMenu.add(locationx,1,3);
        driverAddMenu.add(y,1,4);
        driverAddMenu.add(locationy,1,5);
        driverAddMenu.add(capacityText,1,6);
        driverAddMenu.add(capacity ,1,7);
        driverAddMenu.add(categoriesList ,1,8);

        driverAddMenu.add(back, 2, 1);
        return new Scene(driverAddMenu, 1200, 600);
    }
    public void addDriver(Long locationx, Long locationy, String name, Integer capacity, CarCategory category){
        ruben.addDriver(new Driver
                (new CreditCard(),
                 new Location(locationx, locationy), name,
                 new Car(capacity, category), ruben ));
    }
}

