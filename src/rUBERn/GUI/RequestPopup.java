package rUBERn.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rUBERn.Client;
import rUBERn.Journey;

import java.util.Optional;

/**
 * Created by facundo on 10/31/16.
 */
public class RequestPopup {
    private boolean answer;
    private String client;
    private float destinationX;
    private float destinationY;

    public RequestPopup(Journey journey, Client client){
        answer = false;
        this.client = client.getName();
        destinationY = journey.getDestination().getY();
        destinationX = journey.getDestination().getX();
    }

    public boolean getAnswer() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Would you like to take " + client + " To " + destinationX + " , " + destinationY);
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        return true;
        } else {
        return false;
        }
    }
}
