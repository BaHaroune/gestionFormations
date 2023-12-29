package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ParticipantController implements Initializable {
    @FXML
    private TableView<Participant> tbData;

    @FXML
    public TableColumn<Participant, Integer> matricule;
    @FXML
    public TableColumn<Participant, String> nom;
    @FXML
    public TableColumn<Participant, String> prenom;
    @FXML
    public TableColumn<Participant, String> date_naissance; // Ensure this matches the data type in Participant
    @FXML
    public TableColumn<Participant, String> profil;
    @FXML
    public Button supp;
    @FXML Button modifier;

    private ObservableList<Participant> participants = FXCollections.observableArrayList();

    @FXML
    public void handleClick(ActionEvent event) throws IOException {
        if (event.getSource() == supp) {
            handleSuppAction();
        } else if (event.getSource() == modifier) {
            handleModifierAction();
        }
    }

    private void handleModifierAction() {
        // TODO: Add logic for the modifier action
    }

    private void handleSuppAction() throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("form.fxml"));
        Scene scene = new Scene(fxmlLoader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Bind table columns with Participant properties
        System.out.println("Initializing Participants Controller");
        matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        date_naissance.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));

        // Populate the participants list
        populateParticipants();

        // Set items to the table
        tbData.setItems(participants);
    }

    private void populateParticipants() {
        try (Connection connection = db_cnx.getCnx();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Participant")) {

            // Loop over the ResultSet
            while (resultSet.next()) {
                Participant participant = new Participant(
                        resultSet.getInt("matricule"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getDate("date_naissance"),
                        resultSet.getString("profil")
                );
                participants.add(participant);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}