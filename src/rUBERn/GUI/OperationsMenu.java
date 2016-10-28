package rUBERn.GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by facundo on 10/28/16.
 */
public class OperationsMenu {
    private Stage primaryStage;
    private MainMenu mainMenu;
    public OperationsMenu(Stage primaryStage, MainMenu mainMenu){
        this.primaryStage = primaryStage;
        this.mainMenu = mainMenu;
    }
    public Scene getScene(){
        GridPane gp = new GridPane();
        gp.setHgap(100);
        gp.setVgap(100);
        gp.setPadding(new Insets(25, 25, 25, 25));
        ScrollPane pane = new ScrollPane();
        gp.add(pane,0,0);
        Button back = new Button();
        back.setText("Back");
        back.setOnAction(event -> primaryStage.setScene(mainMenu.getScene()));
        gp.add(back, 0,1);
        File file = new File("Operations.txt");
        String fileAsString = null;
        try {
          ArrayList<String> stringArray = (ArrayList<String>) Files.readAllLines(file.toPath());
            for (int i=0; i<stringArray.size();i++)
                fileAsString += stringArray.get(i) + "\n";
        } catch (IOException e) {
            System.out.println("File not found");
        }

        pane.setContent(new Text(fileAsString));


        return new Scene(gp,1200,600);
    }
}
