package com.projet.AppResidents.dto;

import com.projet.AppResidents.model.ChambreStatut;

public class ChambreRequestDTO {
    private String numero;
    private double taille;
    private String equipements;
    private ChambreStatut etat; // Utilisation de l'énumération EtatChambre
    //private Long residentId; // ID du résident associé
    private Long administrateur_id; // ID de l'administrateur associé

    // Getters et Setters
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

    /*public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }*/

    public Long getAdministrateurId() {
        return administrateur_id;
    }

    public void setAdministrateurId(Long administrateur_id) {
        this.administrateur_id = administrateur_id;
    }
}