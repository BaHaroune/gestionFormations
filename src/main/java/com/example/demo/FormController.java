package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormController {

    @FXML
    private Button supprimer;
    @FXML
    private TextField matricule;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField date_naissance;
    @FXML
    private TextField profil;


    public void initialize() {
        System.out.printf("Initilising...");
        matricule.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                fetchDataForMatricule(newValue);
            }
        });
    }

    private void fetchDataForMatricule(String matricule) {
        // Database fetching logic here
        // Example:
        String query = "SELECT * FROM Participant WHERE matricule = " + matricule;
        try (Connection connection = db_cnx.getCnx();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Loop over the ResultSet
            while (resultSet.next()) {
                nom.setText(resultSet.getString("nom"));
                prenom.setText(resultSet.getString("prenom"));
                date_naissance.setText(resultSet.getString("date_naissance"));
                profil.setText(resultSet.getString("profil"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void suppression() {
        String query = "DELETE FROM Participant WHERE matricule = '" + matricule.getText() + "'";
        try (Connection connection = db_cnx.getCnx();
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);
            System.out.println(rowsAffected + " rows deleted.");

            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("confirmationMsg.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(fxmlLoader));
            stage.show();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

