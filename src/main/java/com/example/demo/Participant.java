package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Participant extends Utilisateur{
    private SimpleIntegerProperty matricule;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private Date date_naissance; // Change to SimpleStringProperty
    private SimpleStringProperty profil;


    public Participant(SimpleIntegerProperty code_utilisateur, SimpleStringProperty login, SimpleStringProperty password, SimpleStringProperty role, int matricule, String nom, String prenom, java.util.Date dateNaiss, String profil) {
        super(code_utilisateur, login, password, role);
        this.matricule = new SimpleIntegerProperty(matricule);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.date_naissance = date_naissance;
        this.profil = new SimpleStringProperty(profil);
    }
    public Participant(int matricule, String nom, String prenom, Date date_naissance, String profil) {
        this.matricule = new SimpleIntegerProperty(matricule);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.date_naissance = date_naissance;
        this.profil = new SimpleStringProperty(profil);
    }

    public int getMatricule() {
        return matricule.get();
    }

    public SimpleIntegerProperty matriculeProperty() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule.set(matricule);
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getProfil() {
        return profil.get();
    }

    public SimpleStringProperty profilProperty() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil.set(profil);
    }
}
