package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class FormateurController implements Initializable {
    @FXML
    private TableView<Formateur> tbData;

    @FXML
    public TableColumn<Formateur, Integer> code_formateur;
    @FXML
    public TableColumn<Formateur, String> nom;
    @FXML
    public TableColumn<Formateur, String> prenom;
    @FXML
    public TableColumn<Formateur, String> email; // Ensure this matches the data type in  Formateur
    @FXML
    public TableColumn<Formateur, String> numeroTel;
    @FXML
    public Button supp;
    @FXML
    Button modifier;

    private ObservableList<Formateur> formateurs = FXCollections.observableArrayList();

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
        // Bind table columns with  Formateur properties
        System.out.println("Initializing  Formateurs Controller");
        code_formateur.setCellValueFactory(new PropertyValueFactory<>("code_formateur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        numeroTel.setCellValueFactory(new PropertyValueFactory<>("numeroTel"));

        // Populate the participants list
        populateFormateurs();

        // Set items to the table
        tbData.setItems(formateurs);
    }

    private void populateFormateurs() {
        try (Connection connection = db_cnx.getCnx();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Formateur")) {

            while (resultSet.next()) {
                Formateur formateur = new Formateur(
                        new SimpleIntegerProperty(resultSet.getInt("code_formateur")),
                        new SimpleStringProperty(resultSet.getString("nom")),
                        new SimpleStringProperty(resultSet.getString("prenom")),
                        new SimpleStringProperty(resultSet.getString("email")),
                        new SimpleStringProperty(resultSet.getString("N_telephone"))
                );
                formateurs.add(formateur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
