package com.projet.AppResidents.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numero;
    private double taille;
    private String equipements;

    @Enumerated(EnumType.STRING) // Indique que le champ est une énumération
    private ChambreStatut etat; // Utilisation de l'énumération EtatChambre

    @OneToOne(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "chambre_id", nullable = false)
    private Resident resident;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Requete> requets;

    @ManyToOne
    @JoinColumn(name = "administrateur_id")
    private Administrateur administrateur;

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

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public List<Requete> getRequets() {
        return requets;
    }

    public void setRequets(List<Requete> requets) {
        this.requets = requets;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}