package com.projet.AppResidents.dto;

import com.projet.AppResidents.model.ChambreStatut;
import java.util.List;

public class ChambreResponseDTO {
    private Long id;
    private String numero;
    private double taille;
    private String equipements;
    private ChambreStatut etat; // Utilisation de l'énumération EtatChambre
    private Long residentId; // ID du résident associé
    private Long administrateurId; // ID de l'administrateur associé
    private List<Long> requeteIds; // IDs des requêtes associées

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    public ChambreStatut getEtat() {
        return etat;
    }

    public void setEtat(ChambreStatut etat) {
        this.etat = etat;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public Long getAdministrateurId() {
        return administrateurId;
    }

    public void setAdministrateurId(Long administrateurId) {
        this.administrateurId = administrateurId;
    }

    public List<Long> getRequeteIds() {
        return requeteIds;
    }

    public void setRequeteIds(List<Long> requeteIds) {
        this.requeteIds = requeteIds;
    }
}