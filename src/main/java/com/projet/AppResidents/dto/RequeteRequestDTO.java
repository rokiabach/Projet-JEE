package com.projet.AppResidents.dto;

import java.time.LocalDate;

public class RequeteRequestDTO {
    private String typeProbleme;
    private String description;
    private String statut;
    private LocalDate dateSignalement;
    private LocalDate dateResolution;
    /*private Long chambreId; // ID de la chambre associée
    private Long residentId; // ID du résident associé
    private Long technicienId; // ID du technicien associé*/

    // Getters et Setters
    public String getTypeProbleme() {
        return typeProbleme;
    }

    public void setTypeProbleme(String typeProbleme) {
        this.typeProbleme = typeProbleme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(LocalDate dateSignalement) {
        this.dateSignalement = dateSignalement;
    }

    public LocalDate getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(LocalDate dateResolution) {
        this.dateResolution = dateResolution;
    }

    /*public Long getChambreId() {
        return chambreId;
    }

    public void setChambreId(Long chambreId) {
        this.chambreId = chambreId;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public Long getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(Long technicienId) {
        this.technicienId = technicienId;
    }*/
}