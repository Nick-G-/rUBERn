package rUBERn.GUI;

import javafx.scene.control.*;
import rUBERn.Client;
import rUBERn.Journey;
import java.util.Optional;

/**
 * Created by facundo on 10/31/16.
 */
public class RequestPopup {
    private String client;
    private float destinationX;
    private float destinationY;

    public RequestPopup(Journey journey, Client client){
        this.client = client.getName();
        destinationY = journey.getDestination().getY();
        destinationX = journey.getDestination().getX();
    }

    public boolean getAnswer() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Trip avaliable");
        alert.setContentText("Would you like to take " + client + " To " + destinationX + " , " + destinationY);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}
