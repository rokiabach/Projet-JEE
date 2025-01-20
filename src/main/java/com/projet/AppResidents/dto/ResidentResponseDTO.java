package com.projet.AppResidents.dto;

import java.util.List;

public class ResidentResponseDTO {
    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private Long chambreId; // ID de la chambre associée
    private List<Long> requeteIds; // IDs des requêtes associées

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getChambreId() {
        return chambreId;
    }

    public void setChambreId(Long chambreId) {
        this.chambreId = chambreId;
    }

    public List<Long> getRequeteIds() {
        return requeteIds;
    }

    public void setRequeteIds(List<Long> requeteIds) {
        this.requeteIds = requeteIds;
    }
}