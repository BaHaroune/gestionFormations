package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    @FXML
    private Button seConnecter;
    @FXML
    private Label errorMsg;
    @FXML
    private TextField nom;
    @FXML
    private PasswordField motDePasse;


    public void loginSys(ActionEvent e) throws SQLException {
        if (nom.getText().isBlank() == false && motDePasse.getText().isBlank() == false){
//            errorMsg.setText("Fields full");
            login();
        } else {
            errorMsg.setText("Fields empty");
        }
    }

    public void login() throws SQLException {
        db_cnx connectNow = new db_cnx();
        Connection cnxDB = connectNow.getCnx();

        String verifLogin = "Select count(1) from utilisateur where login='"+nom.getText()+"' and password ='"+motDePasse.getText()+"'";

        try {
            Statement statement = cnxDB.createStatement();
            ResultSet queryResults = statement.executeQuery(verifLogin);

            while(queryResults.next()) {
                if(queryResults.getInt(1) == 1){
                    errorMsg.setText("Welcome Buddy !");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                    Parent root = loader.load();
                    Scene dashboardScene = new Scene(root);
                    Stage stage = (Stage) seConnecter.getScene().getWindow(); // Assuming seConnecter is a button
                    stage.setScene(dashboardScene);
                    stage.setTitle("Administrateur");
                } else {
                    errorMsg.setText("Naah bro, this credentiels are false !");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
