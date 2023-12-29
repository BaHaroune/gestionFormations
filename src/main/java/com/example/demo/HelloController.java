package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button btnParticipants;

    @FXML
    private Button btnFormateurs;

    @FXML
    private Button btnFormations;
    @FXML
    private Button ajoutUser;
    @FXML
    private Button ajoutFormation;
    @FXML
    private Button ajoutFormateur;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnFormateurs) {
            loadStage("formateurs.fxml");
        } else if (mouseEvent.getSource() == btnFormations) {
            loadStage("formations.fxml");
        } else if (mouseEvent.getSource() == btnParticipants) {
            loadStage("participants.fxml");
        } else if(mouseEvent.getSource() == ajoutUser){
            loadStage("userForm.fxml");
        }else if(mouseEvent.getSource() == ajoutFormateur){
            loadStage("addForm.fxml");
        }else if(mouseEvent.getSource() == ajoutFormation){
            loadStage("addFormation.fxml");
        }
    }

    private void loadStage(String fxml) {
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}