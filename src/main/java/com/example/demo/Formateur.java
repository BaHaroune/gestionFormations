package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Formateur extends Utilisateur {
    private SimpleIntegerProperty code_formateur;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email; // Change to SimpleStringProperty
    private SimpleStringProperty numeroTel;


    public Formateur(SimpleIntegerProperty code_utilisateur, SimpleStringProperty login, SimpleStringProperty password, SimpleStringProperty role, SimpleIntegerProperty code_formateur, SimpleStringProperty nom, SimpleStringProperty prenom, SimpleStringProperty email, SimpleStringProperty numeroTel) {
        super(code_utilisateur, login, password, role);
        this.code_formateur = code_formateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTel = numeroTel;
    }

    public Formateur(SimpleIntegerProperty code_formateur, SimpleStringProperty nom, SimpleStringProperty prenom, SimpleStringProperty email, SimpleStringProperty numeroTel) {
        this.code_formateur = code_formateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTel = numeroTel;
    }


    public int getCode_formateur() {
        return code_formateur.get();
    }

    public SimpleIntegerProperty code_formateurProperty() {
        return code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        this.code_formateur.set(code_formateur);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getNumeroTel() {
        return numeroTel.get();
    }

    public SimpleStringProperty numeroTelProperty() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel.set(numeroTel);
    }
}
