package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmationController {
    @FXML
    private Button ok;

    public void redirect() throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("participants.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader));
        stage.show();
    }
}
