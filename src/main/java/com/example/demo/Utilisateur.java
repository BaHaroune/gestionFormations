package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Utilisateur {
    private SimpleIntegerProperty code_utilisateur;
    private SimpleStringProperty login;
    private SimpleStringProperty password;
    private SimpleStringProperty role;

    public Utilisateur() {
    }

    public Utilisateur(SimpleIntegerProperty code_utilisateur, SimpleStringProperty login, SimpleStringProperty password, SimpleStringProperty role) {
        this.code_utilisateur = code_utilisateur;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getCode_utilisateur() {
        return code_utilisateur.get();
    }

    public SimpleIntegerProperty code_utilisateurProperty() {
        return code_utilisateur;
    }

    public void setCode_utilisateur(int code_utilisateur) {
        this.code_utilisateur.set(code_utilisateur);
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }
}
